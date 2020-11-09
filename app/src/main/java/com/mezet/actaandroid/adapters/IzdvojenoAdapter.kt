package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.izdvojeni.IzdvojenoPayload
import com.mezet.actaandroid.models.kojepratim.KojePratimPayload

class IzdvojenoAdapter(val choosed : String,val izdvojenoPayload: IzdvojenoPayload, val context : Context) :
    RecyclerView.Adapter<IzdvojenoAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val datum = itemView.findViewById(R.id.izdvojeno_datum) as TextView
        val text1 = itemView.findViewById(R.id.izdvojeno_text) as TextView
        val vazido = itemView.findViewById(R.id.izdvojeno_vazido) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.izdvojeno_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if(choosed=="tenderi")
            return izdvojenoPayload.tender.tenders.size
        else if(choosed=="clanci")
            return izdvojenoPayload.article.articles.size
        else
            return izdvojenoPayload.promo.promos.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(choosed=="tenderi"){
            holder.datum.text = izdvojenoPayload.tender.tenders[position].tender_datum
            holder.text1.text= izdvojenoPayload.tender.tenders[position].tender_name
            holder.vazido.text="(važi do "+izdvojenoPayload.tender.tenders[position].tender_validto+")"
        }else if(choosed=="clanci"){
            holder.datum.text = izdvojenoPayload.article.articles[position].article_datum
            holder.text1.text= izdvojenoPayload.article.articles[position].article_name
            holder.vazido.text="(važi do "+izdvojenoPayload.article.articles[position].article_validto+")"
        }else{
            holder.datum.text = izdvojenoPayload.promo.promos[position].promo_datum
            holder.text1.text= izdvojenoPayload.promo.promos[position].promo_name
            holder.vazido.text="(važi do "+izdvojenoPayload.promo.promos[position].promo_validto+")"
        }
    }
}