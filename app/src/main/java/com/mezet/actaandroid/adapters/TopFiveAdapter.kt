package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.models.promohomepage.PromoHome

class TopFiveAdapter(val promoHome: PromoHome, val context : Context,page:Int) :
    RecyclerView.Adapter<TopFiveAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title_text = itemView.findViewById(R.id.title_promo) as TextView
        val text_promo = itemView.findViewById(R.id.text_promo) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopFiveAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_promo_vijesti,parent,false)
        return ViewHolder(v)
    }
    val screen = page
    override fun getItemCount(): Int {
        if(screen==1){
            if(promoHome.MostRecentArticles.size>5)
                return 5
            else
                return promoHome.MostRecentArticles.size
        }else{
            if(promoHome.MostPopularArticles.size>5)
                return 5
            else
                return promoHome.MostPopularArticles.size
        }
    }

    override fun onBindViewHolder(holder: TopFiveAdapter.ViewHolder, position: Int) {
        if(screen==1){
            holder.title_text.text=promoHome.MostRecentArticles[position].PromoCategory
            holder.text_promo.text=promoHome.MostRecentArticles[position].Title
        }else{
            holder.title_text.text=promoHome.MostPopularArticles[position].PromoCategory
            holder.text_promo.text=promoHome.MostPopularArticles[position].Title
        }

    }
}