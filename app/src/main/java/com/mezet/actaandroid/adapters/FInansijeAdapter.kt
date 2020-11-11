package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload

class FInansijeAdapter(val clientCompany: CompanyPayload, val context : Context) :
    RecyclerView.Adapter<FInansijeAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val godina = itemView.findViewById(R.id.textView223) as TextView
        val ukupan_prihod = itemView.findViewById(R.id.textView220) as TextView
        val ukupna_imovina = itemView.findViewById(R.id.textView221) as TextView
        val dobit = itemView.findViewById(R.id.textView219) as TextView
        val broj_radnika = itemView.findViewById(R.id.textView224) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.finansije_registar_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return clientCompany.finansije.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.godina.text=clientCompany.finansije[position].Godina
        holder.ukupan_prihod.text=clientCompany.finansije[position].UkupanPrihod
        holder.ukupna_imovina.text=clientCompany.finansije[position].UkupnaImovina
        holder.dobit.text=clientCompany.finansije[position].SveobuhvatnaZarada
        holder.broj_radnika.text=clientCompany.finansije[position].BrojRadnika
    }
}