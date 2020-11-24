package com.mezet.actaandroid.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.JedinstvenaVijestActivity
import com.mezet.actaandroid.models.promohomepage.PromoHome
import com.mezet.actaandroid.models.rezultativijesti.RezultatiVijesti

class RezultatiVijestiAdapter(val rezultatiVijesti: RezultatiVijesti, val context : Context,pretraga:String) :
    RecyclerView.Adapter<RezultatiVijestiAdapter.ViewHolder>() {
    val pretraga_text = pretraga
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val vijesti_title = itemView.findViewById(R.id.rezultati_vijesti_title) as TextView
        val vijesti_datum = itemView.findViewById(R.id.rezultati_datum) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.rezultati_vijesti_item,parent,false)
        Log.d("pretraga: ","adapter: "+pretraga_text)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return rezultatiVijesti.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.vijesti_title.text=rezultatiVijesti[position].NewsTitle
        val datum = rezultatiVijesti[position].NewsDate.substring(5,7)+"."+rezultatiVijesti[position].NewsDate.substring(8,10)+"."+rezultatiVijesti[position].NewsDate.substring(0,4)+"."
        holder.vijesti_datum.text=datum
        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent (context, JedinstvenaVijestActivity::class.java)
            intent.putExtra("article_id", rezultatiVijesti[position].NewsId)
            intent.putExtra("vrati_na","pretraga")
            intent.putExtra("zadnja_pretraga",pretraga_text)
            context.startActivity(intent)
            Log.d("article_id","saljem: "+rezultatiVijesti[position].NewsId)
        })
    }
}