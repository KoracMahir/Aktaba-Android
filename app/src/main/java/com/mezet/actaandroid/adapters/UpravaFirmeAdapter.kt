package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload

class UpravaFirmeAdapter(val clientCompany: CompanyPayload, val context : Context) :
    RecyclerView.Adapter<UpravaFirmeAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val pozicija = itemView.findViewById(R.id.textView234) as TextView
        val ovlasca = itemView.findViewById(R.id.textView235) as TextView
        val fullime = itemView.findViewById(R.id.textView233) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.uprava_registar_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return clientCompany.Uprava.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.fullime.text=clientCompany.Uprava[position].FullName
        holder.pozicija.text=clientCompany.Uprava[position].Position
        holder.ovlasca.text=clientCompany.Uprava[position].Authorisations
    }
}