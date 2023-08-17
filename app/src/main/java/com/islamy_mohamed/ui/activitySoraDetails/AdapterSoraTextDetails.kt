package com.islamy_mohamed.ui.activitySoraDetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.islamy_mohamed.R

class AdapterSoraTextDetails (var list:List<String>) :Adapter<AdapterSoraTextDetails.viewHolder>(){
    class viewHolder(itemView : View) : ViewHolder(itemView){
      var SoraDetails : TextView = itemView.findViewById(R.id.text_sora_details)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_text_sora,parent,false)
        return viewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        val item = list[position]
     holder.SoraDetails.setText(item)
    }
}