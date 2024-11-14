package com.islamy_mohamed.persentation.ui.home.fragments.radio

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Context
import android.content.Intent
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.widget.RemoteViews
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import com.islamy_mohamed.R
import com.islamy_mohamed.data.model.RadiosItem
import com.islamy_mohamed.domain.useCase.RadiosUseCase
import com.islamy_mohamed.persentation.ui.home.HomeActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

const val PREVIOUS_ACTION = "Previous_Action"
const val NEXT_ACTION = "Next_Action"
const val PLAY_ACTION = "Play_Action"
const val CLOSE_ACTION = "Close_Action"

@AndroidEntryPoint
class RadioService : Service() {
    private var radios: List<RadiosItem?>? = null
    private lateinit var mediaPlayer: MediaPlayer
    private var currentRadioIndex = 0
    @Inject lateinit var radiosUseCase: RadiosUseCase
    private lateinit var notificationRemoteViews: RemoteViews

    override fun onCreate() {
        super.onCreate()
        notificationRemoteViews = RemoteViews(this.packageName, R.layout.notification_view)
        runBlocking {
            radios = radiosUseCase.execute()
        }
        if(!radios.isNullOrEmpty()) initMediaPlayer()
    }

    override fun onBind(p0: Intent?): IBinder? = null

    @RequiresApi(Build.VERSION_CODES.S)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            PREVIOUS_ACTION -> playPreviousRadio()
            NEXT_ACTION -> playNextRadio()
            PLAY_ACTION -> {
                if (mediaPlayer.isPlaying){
                    mediaPlayer.pause()
                }
                else {
                    mediaPlayer.start()
                }
            }

            CLOSE_ACTION -> {
                stopSelf()
            }
        }
        setupService()
        return START_STICKY
    }

    private fun initMediaPlayer() {
        mediaPlayer = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(radios!![currentRadioIndex]?.url)
            prepareAsync()
            setOnPreparedListener {
                start()
            }
        }
    }

    private fun playPreviousRadio() {
        currentRadioIndex = if (currentRadioIndex == 0) radios?.size!! - 1 else --currentRadioIndex
        mediaPlayer.reset()
        mediaPlayer.setDataSource(radios!![currentRadioIndex]?.url)
        mediaPlayer.prepareAsync()
        notificationRemoteViews.setTextViewText(R.id.radio_name, radios!![currentRadioIndex]?.name)
    }

    private fun playNextRadio() {
        currentRadioIndex = if (currentRadioIndex == radios?.size!! - 1) 0 else ++currentRadioIndex
        mediaPlayer.reset()
        mediaPlayer.setDataSource(radios!![currentRadioIndex]?.url)
        mediaPlayer.prepareAsync()
        notificationRemoteViews.setTextViewText(R.id.radio_name, radios!![currentRadioIndex]?.name)
    }

    override fun onDestroy() {
        super.onDestroy()
        if(!radios.isNullOrEmpty()){
            mediaPlayer.pause()
            mediaPlayer.release()
        }
    }

    private fun setupService() {
        createNotificationChannel()
        if (!radios.isNullOrEmpty()) {
            notificationRemoteViews.setTextViewText(R.id.radio_name, radios!![currentRadioIndex]?.name)
        }

    onClickPreviousAction()

        onClickNextAction()

        onClickPlayAction()

        onClickCloseAction()


        val intent = Intent(this, HomeActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(
            this, 100, intent, PendingIntent.FLAG_IMMUTABLE
        )
        val notification = NotificationCompat.Builder(this, "RadioNotificationId")
            .setSmallIcon(R.drawable.radio)
            .setContent(notificationRemoteViews)
            .setContentIntent(pendingIntent)
            .build()
        if(!radios.isNullOrEmpty())
            startForeground(100, notification)
    }

    private fun onClickCloseAction() {
        val stopIntent = Intent(this, RadioService::class.java).apply {
            action = CLOSE_ACTION
        }
        val stopPendingIntent = PendingIntent.getService(
            this, 0, stopIntent, PendingIntent.FLAG_IMMUTABLE
        )
        notificationRemoteViews.setOnClickPendingIntent(R.id.close, stopPendingIntent)
    }

    private fun onClickPlayAction() {
        val startIntent = Intent(this, RadioService::class.java).apply {
            action = PLAY_ACTION
        }
        val startPendingIntent = PendingIntent.getService(
            this, 0, startIntent, PendingIntent.FLAG_IMMUTABLE
        )
        notificationRemoteViews.setOnClickPendingIntent(R.id.pause_radio, startPendingIntent)
    }

    private fun onClickNextAction() {
        val nextIntent = Intent(this, RadioService::class.java).apply {
            action = NEXT_ACTION
        }
        val nextPendingIntent = PendingIntent.getService(
            this, 0, nextIntent, PendingIntent.FLAG_IMMUTABLE
        )
        notificationRemoteViews.setOnClickPendingIntent(R.id.next_radio, nextPendingIntent)
    }

    private fun onClickPreviousAction() {
        val previousIntent = Intent(this, RadioService::class.java).apply {
            action = PREVIOUS_ACTION
        }
        val previousPendingIntent = PendingIntent.getService(
            this, 0, previousIntent, PendingIntent.FLAG_IMMUTABLE
        )
        notificationRemoteViews.setOnClickPendingIntent(R.id.previous, previousPendingIntent)
    }

    private fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                "RadioNotificationId",
                "Radio Notification",
                NotificationManager.IMPORTANCE_DEFAULT
            )
            (this.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager)
                .createNotificationChannel(channel)
        }
    }

}