package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload

class RobneMarkeAdapter (val clientCompany: CompanyPayload, val context : Context) :
    RecyclerView.Adapter<RobneMarkeAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val naslov = itemView.findViewById(R.id.textView146) as TextView
        val url = itemView.findViewById(R.id.textView147) as TextView
        val desc = itemView.findViewById(R.id.textView148) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.robne_marke_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return clientCompany.CompanyAssortments.size

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.naslov.text=clientCompany.CompanyAssortments[position].Title
        holder.url.text=clientCompany.CompanyAssortments[position].Url
        holder.desc.text=clientCompany.CompanyAssortments[position].Description
    }

}