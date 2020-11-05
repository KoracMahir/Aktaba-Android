package com.mezet.actaandroid.adapters

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews


class VijestiAdapterTwo(val mostRecentNews: MostRecentNews?,val context : Context) :
    RecyclerView.Adapter<VijestiAdapterTwo.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.vijesti_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if (mostRecentNews != null) {
            return 2
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
            .into(holder.image_vijesti)
        holder.text_vijesti.text = mostRecentNews?.get(position)?.news_name
        Log.d("position",position.toString())
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
//        val image_big_vijesti = itemView.findViewById(R.id.image_big_one) as ImageView
//        val text_big_vijesti = itemView.findViewById(R.id.title_big_one) as TextView

        val image_vijesti = itemView.findViewById(R.id.image_vijesti_2) as ImageView
        val text_vijesti = itemView.findViewById(R.id.big_text) as TextView
    }

}