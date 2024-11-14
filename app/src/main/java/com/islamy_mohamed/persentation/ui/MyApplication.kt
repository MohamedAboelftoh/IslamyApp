package com.islamy_mohamed.persentation.ui

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.content.getSystemService
import com.islamy_mohamed.R
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    companion object{
        val RADIO_PLAYER_NOTIFICATION_CHANNEL = "radio_channel"
    }
    override fun onCreate() {
        super.onCreate()
        createNotificationChannel()
    }

    private fun createNotificationChannel() {
       if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
       {
           val name = getString(R.string.radio_player_channel)
           val descriptionText = getString(R.string.radio_player_channel_description)
           val importance = NotificationManager.IMPORTANCE_LOW
           val channel = NotificationChannel(RADIO_PLAYER_NOTIFICATION_CHANNEL,name,importance).apply {
               description = descriptionText
           }
           val notificationManager : NotificationManager
            = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
           notificationManager.createNotificationChannel(channel)
       }
    }
}