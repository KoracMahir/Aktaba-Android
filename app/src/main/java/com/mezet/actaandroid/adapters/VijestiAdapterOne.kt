package com.mezet.actaandroid.adapters

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import java.net.URL
import kotlin.coroutines.coroutineContext


class VijestiAdapterOne(val mostRecentNews: MostRecentNews?,val context : Context) :
    RecyclerView.Adapter<VijestiAdapterOne.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.najnovije_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if (mostRecentNews != null) {
            return mostRecentNews.size
        }else{
            return 0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        val newurl = URL(mostRecentNews?.get(position)?.news_image)
//        val mIcon_val = BitmapFactory.decodeStream(newurl.openConnection().getInputStream())
//        holder.image_vijesti.setImageBitmap(mIcon_val)
        Glide
            .with(context)
            .load(mostRecentNews?.get(position)?.news_image)
            .centerCrop()
            .into(holder.image_vijesti);
        holder.text_vijesti.text = mostRecentNews?.get(position)?.news_name
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val image_vijesti = itemView.findViewById(R.id.image_vijesti) as ImageView
        val text_vijesti = itemView.findViewById(R.id.text_vijesti) as TextView
    }

}