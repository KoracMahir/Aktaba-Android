package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.models.promo.PromoPayload
import com.mezet.actaandroid.models.promohomepage.PromoHome

class PromoTopAdapter(val promoHome: PromoHome, val context : Context) :
    RecyclerView.Adapter<PromoTopAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image_vijesti = itemView.findViewById(R.id.image_vijesti) as ImageView
        val text_vijesti = itemView.findViewById(R.id.text_vijesti) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.najnovije_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return promoHome.SugestedArticles.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide
            .with(context)
            .load(promoHome.SugestedArticles?.get(position)?.ImgName)
            .centerCrop()
            .into(holder.image_vijesti);
        holder.text_vijesti.text = promoHome.SugestedArticles?.get(position)?.Title
    }
}