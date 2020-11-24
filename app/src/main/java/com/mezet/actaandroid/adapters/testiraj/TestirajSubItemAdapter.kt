package com.mezet.actaandroid.adapters.testiraj

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.testiraj_items.Option
import com.mezet.actaandroid.models.testiraj_items.TestirajData

class TestirajSubItemAdapter(val options: List<Option>, val context : Context,groupName:String) :
    RecyclerView.Adapter<TestirajSubItemAdapter.ViewHolder>() {

    val name = groupName
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//        val image_big_vijesti = itemView.findViewById(R.id.image_big_one) as ImageView
//        val text_big_vijesti = itemView.findViewById(R.id.title_big_one) as TextView
        val img = itemView.findViewById(R.id.arrow_up) as ImageView
        val txt = itemView.findViewById(R.id.sub_item_title) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.testiraj_subitem, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return options.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(name=="Tenderi")
            holder.img.setImageResource(R.drawable.ic_arrow_tenderi)
        else if(name=="Registar")
            holder.img.setImageResource(R.drawable.ic_arrow_registar)
        else if(name=="Promo")
            holder.img.setImageResource(R.drawable.ic_arrow_promo)
        else if(name=="Registar plus")
            holder.img.setImageResource(R.drawable.ic_arrow_reg_plus)
        else if(name=="Primarni")
            holder.img.setImageResource(R.drawable.ic_arrow_primarni)
        else if(name=="Premium")
            holder.img.setImageResource(R.drawable.ic_arrow_premium)
        holder.txt.text=options[position].option_name
    }
}