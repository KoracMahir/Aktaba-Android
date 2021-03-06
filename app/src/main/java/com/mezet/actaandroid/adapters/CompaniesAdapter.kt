package com.mezet.actaandroid.adapters

import android.content.Context
import android.graphics.Color
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyAutocompletePayload
import com.mezet.actaandroid.models.mojprofil.ClientCompany

class CompaniesAdapter(val autocompletePayload: CompanyAutocompletePayload, val context : Context) :
    RecyclerView.Adapter<CompaniesAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val text1 = itemView.findViewById(R.id.text_firme) as TextView
        val pozadina = itemView.findViewById(R.id.background_firma) as View
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.naziv_firme_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return autocompletePayload.size
    }
    var nposition=0
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.text1.text = autocompletePayload[position].value
        val npos= nposition
        holder.pozadina.setOnClickListener(View.OnClickListener {
            nposition=position
            notifyDataSetChanged()
        })
        Log.d("pozicija",nposition.toString())
        if(nposition==position){
            holder.pozadina.setBackgroundResource(R.color.akta_blue)
            holder.text1.setTextColor(Color.WHITE)
            onPosition()
        }else{
            holder.pozadina.setBackgroundResource(R.color.white)
            holder.text1.setTextColor(Color.parseColor("#5294E2"))
        }
    }
    fun onPosition():Int{
        return nposition
    }
}