package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.kojepratim.KojePratimPayload

class KompanijeKojePratimAdapter(val kojePratimPayload: KojePratimPayload, val context : Context) :
    RecyclerView.Adapter<KompanijeKojePratimAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val text1 = itemView.findViewById(R.id.pratim_naslov) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.kompanije_koje_pratim_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return kojePratimPayload.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text1.text=kojePratimPayload[position].CompanyName
    }
}