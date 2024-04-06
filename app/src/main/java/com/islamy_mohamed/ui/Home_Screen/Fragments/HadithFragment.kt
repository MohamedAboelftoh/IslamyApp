package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.islamy_mohamed.databinding.FragmentHadethBinding
import com.islamy_mohamed.ui.activityHadethDetails.HadithDetailsActivity

class HadithFragment : Fragment() {
    private lateinit var viewBinding : FragmentHadethBinding
     private var hadithList = ArrayList<String>()
    private lateinit var adapterHadith : AdapterHadithFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewBinding = FragmentHadethBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
    }
private fun fillList(){
    for(i in 0 .. 49)
    {
        hadithList.add("حديث رقم ${i+1}")
    }
}
    private fun initRecyclerView(){
        fillList()
        adapterHadith = AdapterHadithFragment(hadithList)
        viewBinding.RVHadeth.adapter=adapterHadith
        adapterHadith.onItemClickListener = object : AdapterHadithFragment.OnItemClickListener{
            override fun onItemClick(position: Int, name: String) {
                val intent = Intent(context,HadithDetailsActivity::class.java)
                intent.putExtra("index",position)
                intent.putExtra("hadethName",name)
                startActivity(intent)
            }

        }
    }
}