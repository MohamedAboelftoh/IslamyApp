package com.islamy_mohamed.ui.Home_Screen

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.islamy_mohamed.R
import com.islamy_mohamed.databinding.ActivityHomeBinding
import com.islamy_mohamed.ui.Home_Screen.Fragments.HadithFragment
import com.islamy_mohamed.ui.Home_Screen.Fragments.QuranFragment
import com.islamy_mohamed.ui.Home_Screen.Fragments.RadioFragment
import com.islamy_mohamed.ui.Home_Screen.Fragments.SebhaFragment

class HomeActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        onButtonNavigationClick()
    }

    private fun onButtonNavigationClick() {
        viewBinding.content.btnNav.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.icon_quran) {
                pushFragment(QuranFragment())
            }
            if (item.itemId == R.id.icon_hadeth) {
                pushFragment(HadithFragment())
            }
            if (item.itemId == R.id.icon_sebha) {
                pushFragment(SebhaFragment())
            }
            if (item.itemId == R.id.icon_radio) {
                pushFragment(RadioFragment())
            }
            true
        }
        viewBinding.content.btnNav.selectedItemId = R.id.icon_quran
    }

    private  fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }
}