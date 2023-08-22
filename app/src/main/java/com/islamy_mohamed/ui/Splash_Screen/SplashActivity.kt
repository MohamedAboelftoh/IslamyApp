package com.islamy_mohamed.ui.Splash_Screen

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
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
        if (getModeFromSharedpreference() == AppCompatDelegate.MODE_NIGHT_YES)
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        else
        {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
          var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        },3000)
    }
    fun getModeFromSharedpreference():Int{
        val sharedPreferences = getSharedPreferences("mode", Context.MODE_PRIVATE)
       return sharedPreferences.getInt("modeNow",AppCompatDelegate.MODE_NIGHT_NO)
    }
}