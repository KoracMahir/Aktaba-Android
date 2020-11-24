package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.berza.Berza
import com.mezet.actaandroid.models.kursnalista.KursnaLista

class KursnaListaAdapter(val kursnaLista: KursnaLista, val context : Context) :
    RecyclerView.Adapter<KursnaListaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val zemlja = itemView.findViewById(R.id.drzava) as TextView
        val sifra = itemView.findViewById(R.id.sifra) as TextView
        val oznaka = itemView.findViewById(R.id.oznaka) as TextView
        val kupovni = itemView.findViewById(R.id.kupovni) as TextView
        val srednji  = itemView.findViewById(R.id.srednji) as TextView
        val prodajni  = itemView.findViewById(R.id.prodajni) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.kursna_lista_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return kursnaLista.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.zemlja.text=kursnaLista[position].Zemlja
        holder.sifra.text=kursnaLista[position].SifraValute
        holder.oznaka.text=kursnaLista[position].OznakaValute
        holder.kupovni.text=kursnaLista[position].KupovniKurs.toString()
        holder.srednji.text=kursnaLista[position].SrednjiKurs.toString()
        holder.prodajni.text=kursnaLista[position].ProdajniKurs.toString()

    }
}