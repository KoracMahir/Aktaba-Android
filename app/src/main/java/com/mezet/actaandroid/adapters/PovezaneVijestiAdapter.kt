package com.mezet.actaandroid.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.JedinstvenaVijestActivity
import com.mezet.actaandroid.models.jedinstvenavijesti.JedinstvenaVijest

class PovezaneVijestiAdapter(val jedinstvenaVijest: JedinstvenaVijest, val context : Context) :
    RecyclerView.Adapter<PovezaneVijestiAdapter.ViewHolder>() {

    val context1 = context

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val big_text = itemView.findViewById(R.id.big_text) as TextView
        val text_datum = itemView.findViewById(R.id.text_datum) as TextView
        val image_vijesti_2 = itemView.findViewById(R.id.image_vijesti_2) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.povezane_vijesti_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return jedinstvenaVijest.news_related_articles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.big_text.text=jedinstvenaVijest.news_related_articles[position].news_name
        val datum = jedinstvenaVijest.news_related_articles[position].news_date
        holder.text_datum.text=datum.substring(8,10)+"."+datum.substring(5,7)+"."+datum.substring(0,4)+"."
        Glide
            .with(context)
            .load(jedinstvenaVijest.news_related_articles[position].news_image)
            .centerCrop()
            .into(holder.image_vijesti_2)

        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent (context, JedinstvenaVijestActivity::class.java)
            intent.putExtra("article_id", jedinstvenaVijest.news_related_articles[position].news_id)
            context.startActivity(intent)
            Log.d("article_id","saljem: "+jedinstvenaVijest.news_related_articles[position].news_id)
        })
    }
}