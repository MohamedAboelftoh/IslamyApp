package com.islamy_mohamed.ui.Home_Screen.Fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.islamy_mohamed.R

class AdapterForRVQuranFragment (var arr : List<String>) : Adapter<AdapterForRVQuranFragment.viewHolderQuran>() {
    interface OnItemClickListener{
        fun OnItemClick(position : Int , name : String)
    }
    var onItemClickListener : OnItemClickListener?=null

    class viewHolderQuran(itemView : View) : ViewHolder(itemView) {
        var Soraname : TextView = itemView.findViewById(R.id.text_sora)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolderQuran {
        var view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_quran,parent,false)
        return viewHolderQuran(view)
    }

    override fun getItemCount(): Int {
        return arr.size
    }

    override fun onBindViewHolder(holder: viewHolderQuran, position: Int) {
       var item = arr[position]
        holder.Soraname.setText(item)
        holder.itemView.setOnClickListener {
           onItemClickListener?.OnItemClick(position,item)
        }
    }
}