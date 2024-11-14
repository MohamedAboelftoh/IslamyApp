package com.islamy_mohamed.persentation.ui.home.fragments.quran

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.islamy_mohamed.R

class QuranAdapter (private var surahesList : List<String>) : Adapter<QuranAdapter.ViewHolderQuran>() {
    interface OnItemClickListener{
        fun onItemClick(position : Int, name : String)
    }
    var onItemClickListener : OnItemClickListener?=null

    class ViewHolderQuran(itemView : View) : ViewHolder(itemView) {
        var soraName : TextView = itemView.findViewById(R.id.text_sora)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderQuran {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler_view_quran,parent,false)
        return ViewHolderQuran(view)
    }

    override fun getItemCount(): Int {
        return surahesList.size
    }

    override fun onBindViewHolder(holder: ViewHolderQuran, position: Int) {
        val item = surahesList[position]
        holder.soraName.text = item
        holder.itemView.setOnClickListener {
           onItemClickListener?.onItemClick(position,item)
        }
    }
}