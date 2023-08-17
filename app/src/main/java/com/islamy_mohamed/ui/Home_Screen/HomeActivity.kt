package com.islamy_mohamed.ui.Home_Screen

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener
import com.islamy_mohamed.R
import com.islamy_mohamed.databinding.ActivityHomeBinding
import com.islamy_mohamed.ui.Home_Screen.Fragments.HadethFragment
import com.islamy_mohamed.ui.Home_Screen.Fragments.QuranFragment
import com.islamy_mohamed.ui.Home_Screen.Fragments.RadioFragment
import com.islamy_mohamed.ui.Home_Screen.Fragments.SebhaFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.content.btnNav.setOnItemSelectedListener(object : OnItemSelectedListener{
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                if (item.itemId == R.id.icon_quran)
                {
                    pushFragment(QuranFragment())
                }
                if (item.itemId == R.id.icon_hadeth)
                {
                    pushFragment(HadethFragment())
                }
                if (item.itemId == R.id.icon_sebha)
                {
                    pushFragment(SebhaFragment())
                }
                if (item.itemId == R.id.icon_radio)
                {
                    pushFragment(RadioFragment())
                }
                return true

            }

        })
        viewBinding.content.btnNav.selectedItemId = R.id.icon_quran
    }
  private  fun pushFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container,fragment).commit()
    }
}