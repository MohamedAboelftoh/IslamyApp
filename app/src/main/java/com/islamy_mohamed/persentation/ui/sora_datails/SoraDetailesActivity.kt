package com.islamy_mohamed.persentation.ui.sora_datails

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.islamy_mohamed.databinding.ActivityTextOfSoraBinding

class SoraDetailesActivity : AppCompatActivity() {
    private lateinit var viewBinding : ActivityTextOfSoraBinding
    private lateinit var soraName : String
    private var position : Int = 0
    private lateinit var fileContent : String
    private lateinit var adapterSoraText : SoraAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
        viewBinding = ActivityTextOfSoraBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
       putDataInDetailsActivity()
        viewBinding.backIcon.setOnClickListener {
            finish()
        }
    }
    private fun putDataInDetailsActivity(){
        soraName = intent.getStringExtra("nameOfSora")?:""
        position = intent.getIntExtra("index",0)
        viewBinding.nameOfSora.text = soraName
        fileContent = assets.open("$position.txt").bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        adapterSoraText = SoraAdapter(lines)
        viewBinding.contentOfSoraDetails.RVDetails.adapter = adapterSoraText
    }

}