package com.islamy_mohamed.ui.Splash_Screen

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.islamy_mohamed.R
import com.islamy_mohamed.ui.Home_Screen.HomeActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        Handler(Looper.getMainLooper()).postDelayed({
          var intent = Intent(this,HomeActivity::class.java)
            startActivity(intent)
        },3000)
    }
}