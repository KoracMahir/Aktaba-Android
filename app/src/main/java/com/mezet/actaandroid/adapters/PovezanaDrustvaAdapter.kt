package com.mezet.actaandroid.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.mojprofil.ClientCompany

class PovezanaDrustvaAdapter(val companyPayload: CompanyPayload, val context : Context) :
    RecyclerView.Adapter<PovezanaDrustvaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val text1 = itemView.findViewById(R.id.item_text) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.povezana_drustva_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        Log.d("ima ih",""+companyPayload.Povezana_Drustva.size)
        return companyPayload.Povezana_Drustva.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text1.text = companyPayload.Povezana_Drustva.get(position).Fullname
    }
}