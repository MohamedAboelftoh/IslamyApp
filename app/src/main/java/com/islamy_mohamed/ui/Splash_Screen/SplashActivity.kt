package com.islamy_mohamed.ui.Splash_Screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatDelegate
import com.islamy_mohamed.R
import com.islamy_mohamed.ui.Home_Screen.HomeActivity

class SplashActivity : AppCompatActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setMode()
        setContentView(R.layout.activity_splash)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        Handler(Looper.getMainLooper()).postDelayed({
          val intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        },3000)
    }

    private fun setMode() {
        if (getModeFromSharedPreference() == AppCompatDelegate.MODE_NIGHT_YES) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
    }

    private fun getModeFromSharedPreference():Int{
        val sharedPreferences = getSharedPreferences("mode", Context.MODE_PRIVATE)
       return sharedPreferences.getInt("modeNow",AppCompatDelegate.MODE_NIGHT_NO)
    }
}