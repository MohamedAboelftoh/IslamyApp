package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.islamy_mohamed.R

class AdapterForRvHadethFragment (val list : List<String>) : Adapter<AdapterForRvHadethFragment.viewHolder> (){
    lateinit var onItemClickListener : OnItemClickListener
    interface OnItemClickListener {
        fun OnItemClick(position : Int, name : String)
    }
    class viewHolder (itemView : View): ViewHolder (itemView){
        val numOfHadeth : TextView = itemView.findViewById(R.id.number_of_hadeth)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
      val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_hadeth,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
       var item = list[position]
        holder.numOfHadeth.setText(item)
        holder.itemView.setOnClickListener {
            onItemClickListener.OnItemClick(position,item)
        }
    }
}