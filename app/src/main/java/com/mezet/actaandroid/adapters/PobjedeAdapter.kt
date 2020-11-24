package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.pobjedenatenderima.TenderWinners
import com.mezet.actaandroid.models.publishedtenders.PublishedTenders
import org.w3c.dom.Text

class PobjedeAdapter (val winners: TenderWinners, val context : Context) :
    RecyclerView.Adapter<PobjedeAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val date1 = itemView.findViewById(R.id.date4) as TextView
        val date2 = itemView.findViewById(R.id.date5) as TextView
        val tender_name = itemView.findViewById(R.id.text_tendera3) as TextView
        val narucilac = itemView.findViewById(R.id.text_tendera5) as TextView
        val brojtendera  = itemView.findViewById(R.id.text_tendera7) as TextView
        val cijena = itemView.findViewById(R.id.text_tendera8) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.pobjeda_tenderi_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return winners.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.date1.text=winners[position].tender_datum
        holder.date2.text=winners[position].tender_validto
        holder.tender_name.text=winners[position].tender_name
        holder.narucilac.text=winners[position].tender_requester.tender_company_name
        holder.brojtendera.text=winners[position].tender_number
        holder.cijena.text=winners[position].tender_value

    }
}