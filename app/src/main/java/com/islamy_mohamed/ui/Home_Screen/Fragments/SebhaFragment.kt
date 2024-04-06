package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.islamy_mohamed.databinding.FragmentSebhaBinding

class SebhaFragment : Fragment() {
    private lateinit var viewBinding : FragmentSebhaBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentSebhaBinding.inflate(inflater,container,false)
        return viewBinding.root
    }
    @SuppressLint("SuspiciousIndentation")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        onBtnSebhaClick()
    }

    private fun onBtnSebhaClick() {
        var numberOfTaspeh: Int = Integer.parseInt(viewBinding.numOfTaspeh.text.toString())
        viewBinding.btnTaspeh.setOnClickListener {
            viewBinding.bodyOfSepha.rotation = viewBinding.bodyOfSepha.rotation + (360 / 33)
            numberOfTaspeh++
            viewBinding.numOfTaspeh.text = "" + numberOfTaspeh
            if (numberOfTaspeh == 33 && viewBinding.btnTaspeh.text.toString()
                    .equals("سبحان الله")
            ) {
                viewBinding.numOfTaspeh.text = "0"
                numberOfTaspeh = 0
                viewBinding.btnTaspeh.text = "الحمد لله"
            } else if (numberOfTaspeh == 33 && viewBinding.btnTaspeh.text.toString() == "الحمد لله") {
                viewBinding.numOfTaspeh.text = "0"
                numberOfTaspeh = 0
                viewBinding.btnTaspeh.text = "الله اكبر"
            } else if (numberOfTaspeh == 33 && viewBinding.btnTaspeh.text.toString() == "الله اكبر") {
                viewBinding.numOfTaspeh.text = "0"
                numberOfTaspeh = 0
                viewBinding.btnTaspeh.text = "سبحان الله"
            }
        }
    }

}