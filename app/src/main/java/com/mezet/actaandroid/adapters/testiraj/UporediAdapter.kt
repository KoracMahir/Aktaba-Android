package com.mezet.actaandroid.adapters.testiraj

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.testiraj_items.Option

class UporediAdapter(val options1: List<Option>,val options2: List<Option>,val options3: List<Option>,val options4: List<Option>,
                     val options5: List<Option>,val options6: List<Option>, val context : Context) :
    RecyclerView.Adapter<UporediAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //        val image_big_vijesti = itemView.findViewById(R.id.image_big_one) as ImageView
//        val text_big_vijesti = itemView.findViewById(R.id.title_big_one) as TextView
        val img1 = itemView.findViewById(R.id.tenderi_have) as ImageView
        val img2 = itemView.findViewById(R.id.registar_have) as ImageView
        val img3 = itemView.findViewById(R.id.promo_have) as ImageView
        val img4 = itemView.findViewById(R.id.plus_have) as ImageView
        val img5 = itemView.findViewById(R.id.primarni_have) as ImageView
        val img6 = itemView.findViewById(R.id.premium_have) as ImageView
        val nasov_uporedi = itemView.findViewById(R.id.nasov_uporedi) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.uporedi_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return options6.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        for(x in 0..options1.size-1){
            if(options1[x].option_name==options6[position].option_name){
                holder.img1.setImageResource(R.drawable.ic_arrow_tenderi)
            }
        }
        for(x in 0..options2.size-1){
            if(options2[x].option_name==options6[position].option_name){
                holder.img2.setImageResource(R.drawable.ic_arrow_registar)
            }
        }
        for(x in 0..options3.size-1){
            if(options3[x].option_name==options6[position].option_name){
                holder.img3.setImageResource(R.drawable.ic_arrow_promo)
            }
        }
        for(x in 0..options4.size-1){
            if(options4[x].option_name==options6[position].option_name){
                holder.img4.setImageResource(R.drawable.ic_arrow_reg_plus)
            }
        }
        for(x in 0..options5.size-1){
            if(options5[x].option_name==options6[position].option_name){
                holder.img5.setImageResource(R.drawable.ic_arrow_primarni)
            }
        }
        holder.img6.setImageResource(R.drawable.ic_arrow_premium)
        holder.nasov_uporedi.text=options6[position].option_name
    }
}