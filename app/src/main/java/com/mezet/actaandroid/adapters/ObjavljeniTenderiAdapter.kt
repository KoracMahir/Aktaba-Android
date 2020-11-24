package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.publishedtenders.PublishedTenders

class ObjavljeniTenderiAdapter (val publishedTenders: PublishedTenders, val context : Context) :
    RecyclerView.Adapter<ObjavljeniTenderiAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val date1 = itemView.findViewById(R.id.date2) as TextView
        val date2 = itemView.findViewById(R.id.date3) as TextView
        val title = itemView.findViewById(R.id.text_tendera2) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.objavljeni_tenderi_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return publishedTenders.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date1.text=publishedTenders[position].tender_datum
        holder.date2.text=publishedTenders[position].tender_validto
        holder.title.text=publishedTenders[position].tender_name
    }
}