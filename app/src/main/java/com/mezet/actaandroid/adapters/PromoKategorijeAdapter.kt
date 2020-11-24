package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.promohomepage.PromoHome
import com.mezet.actaandroid.models.promokategorije.PromoKategorije

class PromoKategorijeAdapter(val promoKategorije: PromoKategorije, val context : Context) :
    RecyclerView.Adapter<PromoKategorijeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title_text = itemView.findViewById(R.id.text_kategorija) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.kategorije_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return promoKategorije.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title_text.text=promoKategorije[position].category_name
    }
}