package com.islamy_mohamed.ui.activityHadethDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.islamy_mohamed.databinding.ActivityHadethDetailsBinding

class HadethDetailsActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityHadethDetailsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHadethDetailsBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.backIcon.setOnClickListener {
            finish()
        }
        val positionOfHadeth = intent.getIntExtra("index",0)
        val nameHadeth = intent.getStringExtra("hadethName")
        viewBinding.nameOfHadeth.setText(nameHadeth)
        val fileContentHadeth = assets.open("hadeth.txt").bufferedReader().use { it.readText() }
        val contentOfHadeth = fileContentHadeth.trim().split("#")
        viewBinding.ContentDetailsHadeth.HadethContent.setText(contentOfHadeth[positionOfHadeth])
    }
}