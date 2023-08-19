package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.islamy_mohamed.R
import com.islamy_mohamed.ui.activityHadethDetails.HadethDetailsActivity

class HadethFragment : Fragment() {
    lateinit var RvHadeth : RecyclerView
     var listHadeth = ArrayList<String>()
    lateinit var adapterHadeth : AdapterForRvHadethFragment
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_hadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        RvHadeth = view.findViewById(R.id.RV_Hadeth)
        makeRvHadethWorked()
       adapterHadeth.onItemClickListener = object : AdapterForRvHadethFragment.OnItemClickListener{
           override fun OnItemClick(position: Int, name: String) {
               val intent = Intent(context,HadethDetailsActivity::class.java)
               intent.putExtra("index",position)
               intent.putExtra("hadethName",name)
               startActivity(intent)
           }

       }

    }
fun initList(){
    for(i in 0 .. 49)
    {
        listHadeth.add("حديث رقم ${i+1}")
    }
}
    fun makeRvHadethWorked(){
        initList()
        adapterHadeth = AdapterForRvHadethFragment(listHadeth)
        RvHadeth.adapter=adapterHadeth
    }
}