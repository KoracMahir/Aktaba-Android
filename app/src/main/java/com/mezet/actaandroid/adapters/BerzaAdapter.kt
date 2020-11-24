package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.berza.Berza
import com.mezet.actaandroid.models.pobjedenatenderima.TenderWinners
import kotlinx.android.synthetic.main.fragment_profil_kompanije.view.*

class BerzaAdapter(val berza:Berza, val context : Context,section1:String,section2:String) :
    RecyclerView.Adapter<BerzaAdapter.ViewHolder>() {

    val context1 = context
    val sec1 = section1
    val sec2 = section2
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val code = itemView.findViewById(R.id.code) as TextView
        val issuer = itemView.findViewById(R.id.issuer) as TextView
        val promjena = itemView.findViewById(R.id.promjena) as TextView
        val kurs = itemView.findViewById(R.id.kurs) as TextView
        val promet  = itemView.findViewById(R.id.promet) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.berza_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if(sec1=="sase"){
            if(sec2=="win"){
                return berza.sase.Winners.size
            }else if(sec2=="lose"){
                return berza.sase.Loosers.size
            }else{
                return berza.sase.Turnover.size
            }
        }else if(sec1=="blse"){
            if(sec2=="win"){
                return berza.blse.Winners.size
            }else if(sec2=="lose"){
                return berza.blse.Loosers.size
            }else{
            return berza.blse.Turnover.size }
            }else{
            return 0
        }
        }



    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(sec1=="sase"){
            if(sec2=="win"){
                holder.code.text=berza.sase.Winners[position].Code
                holder.issuer.text=berza.sase.Winners[position].Issuer
                holder.promjena.text=berza.sase.Winners[position].Change.toString()+"%"
                holder.kurs.text=berza.sase.Winners[position].Turnover.toString()
                holder.promet.text=berza.sase.Winners[position].Direction.toString()
            }else if(sec2=="lose"){
                holder.code.text=berza.sase.Loosers[position].Code
                holder.issuer.text=berza.sase.Loosers[position].Issuer
                holder.promjena.text=berza.sase.Loosers[position].Change.toString()+"%"
                holder.kurs.text=berza.sase.Loosers[position].Turnover.toString()
                holder.promet.text=berza.sase.Loosers[position].Direction.toString()
            }else{
                holder.code.text=berza.sase.Turnover[position].Code
                holder.issuer.text=berza.sase.Turnover[position].Issuer
                holder.promjena.text=berza.sase.Turnover[position].Change.toString()+"%"
                holder.kurs.text=berza.sase.Turnover[position].Turnover.toString()
                holder.promet.text=berza.sase.Turnover[position].Direction.toString()
            }
        }else if(sec1=="blse"){
            if(sec2=="win"){
                holder.code.text=berza.blse.Winners[position].Code
                holder.issuer.text=berza.blse.Winners[position].Issuer
                holder.promjena.text=berza.blse.Winners[position].Change.toString()+"%"
                holder.kurs.text=berza.blse.Winners[position].Turnover.toString()
                holder.promet.text=berza.blse.Winners[position].Direction.toString()
            }else if(sec2=="lose"){
                holder.code.text=berza.blse.Loosers[position].Code
                holder.issuer.text=berza.blse.Loosers[position].Issuer
                holder.promjena.text=berza.blse.Loosers[position].Change.toString()+"%"
                holder.kurs.text=berza.blse.Loosers[position].Turnover.toString()
                holder.promet.text=berza.blse.Loosers[position].Direction.toString()
            }else{
                holder.code.text=berza.blse.Turnover[position].Code
                holder.issuer.text=berza.blse.Turnover[position].Issuer
                holder.promjena.text=berza.blse.Turnover[position].Change.toString()+"%"
                holder.kurs.text=berza.blse.Turnover[position].Turnover.toString()
                holder.promet.text=berza.blse.Turnover[position].Direction.toString()
            }
        }
    }
}