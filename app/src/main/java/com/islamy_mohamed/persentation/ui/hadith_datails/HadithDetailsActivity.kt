package com.islamy_mohamed.persentation.ui.hadith_datails

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.islamy_mohamed.databinding.ActivityHadethDetailsBinding

class HadithDetailsActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        viewBinding.backIcon.setOnClickListener {
            finish()
        }
        val positionOfHadith = intent.getIntExtra("index",0)
        val nameHadith = intent.getStringExtra("hadethName")
        viewBinding.nameOfHadeth.text = nameHadith
        val fileContentHadith = assets.open("hadeth.txt").bufferedReader().use { it.readText() }
        val contentOfHadith = fileContentHadith.trim().split("#")
        viewBinding.ContentDetailsHadeth.HadethContent.text = contentOfHadith[positionOfHadith]
    }
}