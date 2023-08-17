package com.islamy_mohamed.ui.activitySoraDetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.islamy_mohamed.databinding.ActivityTextOfSoraBinding

class TextOfSoraActivity : AppCompatActivity() {
    lateinit var viewBinding : ActivityTextOfSoraBinding
    lateinit var SoraName : String
    var position : Int = 0
    lateinit var fileContent : String
    lateinit var adapterSoraText :AdapterSoraTextDetails
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityTextOfSoraBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
       putDataInDetailsActivity()
        viewBinding.backIcon.setOnClickListener {
            finish()
        }
    }
    fun putDataInDetailsActivity(){
        SoraName = intent.getStringExtra("nameOfSora")?:""
        position = intent.getIntExtra("indix",0)
        viewBinding.nameOfSora.setText(SoraName)
        fileContent = assets.open("$position.txt").bufferedReader().use { it.readText() }
        val lines = fileContent.trim().split("\n")
        adapterSoraText = AdapterSoraTextDetails(lines)
        viewBinding.contentOfSoraDetails.RVDetails.adapter = adapterSoraText
    }

}