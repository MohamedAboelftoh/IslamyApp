package com.islamy_mohamed.persentation.ui.home.fragments.hadith

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.islamy_mohamed.databinding.FragmentHadethBinding
import com.islamy_mohamed.persentation.ui.hadith_datails.HadithDetailsActivity

class HadithFragment : Fragment() {
    private lateinit var viewBinding : FragmentHadethBinding
     private var hadithList = ArrayList<String>()
    private lateinit var adapterHadith : HadithAdapter
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
        adapterHadith = HadithAdapter(hadithList)
        viewBinding.RVHadeth.adapter=adapterHadith
        adapterHadith.onItemClickListener = object : HadithAdapter.OnItemClickListener {
            override fun onItemClick(position: Int, name: String) {
                val intent = Intent(context, HadithDetailsActivity::class.java)
                intent.putExtra("index",position)
                intent.putExtra("hadethName",name)
                startActivity(intent)
            }

        }
    }
}