package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.islamy_mohamed.R

class SebhaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sebha, container, false)
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var textNumOfTaspeh : TextView = view.findViewById(R.id.num_Of_taspeh)
        var btnTaspeh : Button = view.findViewById(R.id.btn_taspeh)
        var imgOfSepha : ImageView = view.findViewById(R.id.bodyOfSepha)
        var numberofTaspeh : Int = Integer.parseInt(textNumOfTaspeh.text.toString())
        btnTaspeh.setOnClickListener {
            imgOfSepha.rotation = imgOfSepha.rotation +(360/33)
            numberofTaspeh++
            textNumOfTaspeh.setText(""+numberofTaspeh)
            if(numberofTaspeh == 34 && btnTaspeh.text.toString().equals("سبحان الله")) {
                textNumOfTaspeh.setText("0")
                numberofTaspeh = 0
                btnTaspeh.setText("الحمد لله")
            }
            else if (numberofTaspeh == 34 && btnTaspeh.text.toString().equals("الحمد لله"))
            {
                textNumOfTaspeh.setText("0")
                numberofTaspeh = 0
                btnTaspeh.setText("الله اكبر")
            }
            else if(numberofTaspeh == 34 && btnTaspeh.text.toString().equals("الله اكبر")){
                textNumOfTaspeh.setText("0")
                numberofTaspeh = 0
                btnTaspeh.setText("سبحان الله")
            }
        }
    }

}