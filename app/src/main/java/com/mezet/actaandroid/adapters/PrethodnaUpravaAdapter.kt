package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload

class PrethodnaUpravaAdapter(val clientCompany: CompanyPayload, val context : Context) :
    RecyclerView.Adapter<PrethodnaUpravaAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val pozicija = itemView.findViewById(R.id.textView238) as TextView
        val fullime = itemView.findViewById(R.id.textView237) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.prethodna_uprava_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return clientCompany.ManagerHistory.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fullime.text=clientCompany.ManagerHistory[position].FullName.substringBefore(',')
        holder.pozicija.text=clientCompany.ManagerHistory[position].FullName.substringAfter(',')
    }
}