package com.islamy_mohamed.persentation.ui.home.fragments.hadith

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.islamy_mohamed.R

class HadithAdapter (private val list : List<String>) : Adapter<HadithAdapter.ViewHolder> (){
    lateinit var onItemClickListener : OnItemClickListener
    interface OnItemClickListener {
        fun onItemClick(position : Int, name : String)
    }
    class ViewHolder (itemView : View): RecyclerView.ViewHolder (itemView){
        val numOfHadith : TextView = itemView.findViewById(R.id.number_of_hadeth)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
      val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_rv_hadeth,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       val item = list[position]
        holder.numOfHadith.text = item
        holder.itemView.setOnClickListener {
            onItemClickListener.onItemClick(position,item)
        }
    }
}