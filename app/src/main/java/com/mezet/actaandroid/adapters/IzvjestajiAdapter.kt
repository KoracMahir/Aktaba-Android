package com.mezet.actaandroid.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews

class IzvjestajiAdapter(val clientCompany: CompanyPayload, val context : Context,type:String) :
    RecyclerView.Adapter<IzvjestajiAdapter.ViewHolder>() {

    val text = type

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val transactionalAccountNumber = itemView.findViewById(R.id.textView196) as TextView
        val accountStatusChangeDate = itemView.findViewById(R.id.textView228) as TextView
        val nameOfBank = itemView.findViewById(R.id.textView197) as TextView
//        val accountStatus = itemView.findViewById(R.id.id_djelatnosti) as TextView
//        val nameOfBankUrl = itemView.findViewById(R.id.id_djelatnosti) as TextView
        val accountOpeningDate = itemView.findViewById(R.id.textView226) as TextView
        val accountActivationDate = itemView.findViewById(R.id.textView227) as TextView
//        val accountType = itemView.findViewById(R.id.id_djelatnosti) as TextView
        val mainAccountDate = itemView.findViewById(R.id.textView229) as TextView
//        val mainAccountClosingDate = itemView.findViewById(R.id.id_djelatnosti) as TextView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.izvjestaj_item,parent,false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        if(text=="glavni")
            return clientCompany.MainRns.size
        else if(text=="aktivni")
            return  clientCompany.ActiveTransactionalAccounts.size
        else
            return clientCompany.ClosedTransactionalAccounts.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if(text=="glavni"){
            holder.transactionalAccountNumber.text=clientCompany.MainRns[position].TransactionalAccountNumber
            val statuschangeddate = clientCompany.MainRns[position].AccountStatusChangeDate
            holder.accountStatusChangeDate.text=statuschangeddate.substring(8,10)+"."+statuschangeddate.substring(5,7)+"."+statuschangeddate.substring(0,4)
            holder.nameOfBank.text=clientCompany.MainRns[position].NameOfBank
            val openingdate =clientCompany.MainRns[position].AccountOpeningDate
            holder.accountOpeningDate.text=openingdate.substring(8,10)+"."+openingdate.substring(5,7)+"."+openingdate.substring(0,4)
            val activationdate =clientCompany.MainRns[position].AccountActivationDate
            holder.accountActivationDate.text=activationdate.substring(8,10)+"."+activationdate.substring(5,7)+"."+activationdate.substring(0,4)
            holder.mainAccountDate.text=clientCompany.MainRns[position].MainAccountDate
        }else if(text=="aktivni"){
            holder.transactionalAccountNumber.text=clientCompany.ActiveTransactionalAccounts[position].TransactionalAccountNumber
            val statuschangeddate2 = clientCompany.ActiveTransactionalAccounts[position].AccountStatusChangeDate
            holder.accountStatusChangeDate.text=statuschangeddate2.substring(8,10)+"."+statuschangeddate2.substring(5,7)+"."+statuschangeddate2.substring(0,4)
            holder.nameOfBank.text=clientCompany.ActiveTransactionalAccounts[position].NameOfBank
            val openingdate2 =clientCompany.ActiveTransactionalAccounts[position].AccountOpeningDate
            holder.accountOpeningDate.text=openingdate2.substring(8,10)+"."+openingdate2.substring(5,7)+"."+openingdate2.substring(0,4)
//            val activationdate =clientCompany.ActiveTransactionalAccounts[position].AccountActivationDate
//            holder.accountActivationDate.text=activationdate.substring(8,10)+"."+activationdate.substring(5,7)+"."+activationdate.substring(0,4)
//            holder.mainAccountDate.text=clientCompany.MainRns[position].MainAccountDate
        }else{
            holder.transactionalAccountNumber.text=clientCompany.ClosedTransactionalAccounts[position].TransactionalAccountNumber
            val statuschangeddate3 = clientCompany.ClosedTransactionalAccounts[position].AccountStatusChangeDate
            holder.accountStatusChangeDate.text=statuschangeddate3.substring(8,10)+"."+statuschangeddate3.substring(5,7)+"."+statuschangeddate3.substring(0,4)
            holder.nameOfBank.text=clientCompany.ClosedTransactionalAccounts[position].NameOfBank
            val openingdate3 =clientCompany.ClosedTransactionalAccounts[position].AccountOpeningDate
            holder.accountOpeningDate.text=openingdate3.substring(8,10)+"."+openingdate3.substring(5,7)+"."+openingdate3.substring(0,4)
//            val activationdate3 =clientCompany.ClosedTransactionalAccounts[position].AccountActivationDate
//            holder.accountActivationDate.text=activationdate3.substring(8,10)+"."+activationdate3.substring(5,7)+"."+activationdate3.substring(0,4)
//            holder.mainAccountDate.text=clientCompany.MainRns[position].MainAccountDate
        }
    }

}