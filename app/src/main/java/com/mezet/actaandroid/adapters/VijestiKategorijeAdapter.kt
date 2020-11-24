package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.privreda.PrivredaKategorije
import com.mezet.actaandroid.models.vijestikategorije.VijestiKategorije

class VijestiKategorijeAdapter(val vijestiKategorije: VijestiKategorije, val context : Context) :
    RecyclerView.Adapter<VijestiKategorijeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title_text = itemView.findViewById(R.id.text_kategorija) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.privreda_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return vijestiKategorije.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title_text.text=vijestiKategorije[position].category_name
    }
}