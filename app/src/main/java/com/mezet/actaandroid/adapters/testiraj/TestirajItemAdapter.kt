package com.mezet.actaandroid.adapters.testiraj

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.BlueBlackAdapter
import com.mezet.actaandroid.adapters.PovezanaDrustvaAdapter
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.models.testiraj_items.TestirajData

class TestirajItemAdapter(val testirajData: TestirajData, val context : Context) :
    RecyclerView.Adapter<TestirajItemAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val btn = itemView.findViewById(R.id.button) as Button
        val title_text = itemView.findViewById(R.id.naslov) as TextView
        val price_text = itemView.findViewById(R.id.cijena) as TextView

        val price_text_plus = itemView.findViewById(R.id.cijena2) as TextView
        val price_mjes_plus = itemView.findViewById(R.id.cijenamjesecno) as TextView

        val icon2 = itemView.findViewById(R.id.icon2) as ImageView
        val iconetxt2 = itemView.findViewById(R.id.iconetxt2) as ImageView

        val plus_expand = itemView.findViewById(R.id.plus_expand) as LinearLayout

        val subitems = itemView.findViewById(R.id.sub_recycler_testiraj) as RecyclerView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.testiraj_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return testirajData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(testirajData[position].paket_name=="Tenderi")
            holder.btn.setBackgroundResource(R.color.tenderi)
        else if(testirajData[position].paket_name=="Registar")
            holder.btn.setBackgroundResource(R.color.akte_darkgreen)
        else if(testirajData[position].paket_name=="Promo")
            holder.btn.setBackgroundResource(R.color.promo)
        else if(testirajData[position].paket_name=="Registar plus")
            holder.btn.setBackgroundResource(R.color.akta_cyan)
        else if(testirajData[position].paket_name=="Primarni")
            holder.btn.setBackgroundResource(R.color.akta_grey)
        else if(testirajData[position].paket_name=="Premium")
            holder.btn.setBackgroundResource(R.color.akta_blue)

        holder.price_text.visibility=View.VISIBLE
        holder.title_text.text=testirajData[position].paket_name
        holder.price_text.text=testirajData[position].paket_cijena

        if(testirajData[position].paket_cijena_mjesecno!=null){
            holder.icon2.visibility=View.VISIBLE
            holder.iconetxt2.visibility=View.VISIBLE
            holder.price_text.visibility=View.GONE
            holder.plus_expand.visibility=View.VISIBLE
            holder.price_text_plus.text=testirajData[position].paket_cijena
            holder.price_mjes_plus.text=testirajData[position].paket_cijena_mjesecno
        }

        holder.btn.setOnClickListener(View.OnClickListener {
            if(holder.subitems.visibility==View.VISIBLE){
                holder.subitems.visibility=View.GONE
            }else{
                holder.subitems.visibility=View.VISIBLE
            }
        })
        val adapter =TestirajSubItemAdapter(testirajData[position].options,context,testirajData[position].paket_name)
        holder.subitems.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        holder.subitems.adapter = adapter
    }
}