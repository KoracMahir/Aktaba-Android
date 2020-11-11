package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.mojprofil.ClientCompany

class DjelatnostiAdapter2(val clientCompany: CompanyPayload, val context : Context) :
    RecyclerView.Adapter<DjelatnostiAdapter2.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val id = itemView.findViewById(R.id.id_djelatnosti) as TextView
        val text1 = itemView.findViewById(R.id.djelatnost_text) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.djelatnosti_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return clientCompany.ACList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.id.text = clientCompany?.ACList.get(position).AcCode
        holder.text1.text = clientCompany?.ACList.get(position).AcName
    }
}