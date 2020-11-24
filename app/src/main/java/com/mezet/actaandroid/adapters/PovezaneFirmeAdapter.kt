package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.jedinstvenavijesti.JedinstvenaVijest
import com.mezet.actaandroid.models.publishedtenders.PublishedTenders

class PovezaneFirmeAdapter (val jedinstvenaVijest: JedinstvenaVijest, val context : Context) :
    RecyclerView.Adapter<PovezaneFirmeAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val naziv_firme = itemView.findViewById(R.id.naziv_firme) as TextView
        val ulica_firme = itemView.findViewById(R.id.ulica_firme) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.povezane_firme_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return jedinstvenaVijest.news_related_companies.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.naziv_firme.text=jedinstvenaVijest.news_related_companies[position].company_name
        holder.ulica_firme.text=jedinstvenaVijest.news_related_companies[position].company_address
    }
}