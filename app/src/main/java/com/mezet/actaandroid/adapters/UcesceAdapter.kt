package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.pobjedenatenderima.TenderWinners
import com.mezet.actaandroid.models.ucescenatenderima.UcesceNaTenderima

class UcesceAdapter(val ucesceNaTenderima: UcesceNaTenderima, val context : Context) :
    RecyclerView.Adapter<UcesceAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val date1 = itemView.findViewById(R.id.date6) as TextView
        val date2 = itemView.findViewById(R.id.date7) as TextView
        val tender_name = itemView.findViewById(R.id.text_tendera10) as TextView
        val narucilac = itemView.findViewById(R.id.text_tendera12) as TextView
        val cijena = itemView.findViewById(R.id.text_tendera14) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.ucesce_tenderi_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return ucesceNaTenderima.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date1.text=ucesceNaTenderima[position].tender_datum
        holder.date2.text=ucesceNaTenderima[position].tender_validto
        holder.tender_name.text=ucesceNaTenderima[position].tender_name
        holder.narucilac.text=ucesceNaTenderima[position].tender_requester.tender_company_name
        holder.cijena.text=ucesceNaTenderima[position].tender_value
    }
}