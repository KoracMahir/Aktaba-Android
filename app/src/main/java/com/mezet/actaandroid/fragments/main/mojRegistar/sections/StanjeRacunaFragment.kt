package com.mezet.actaandroid.fragments.main.mojRegistar.sections

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.pretraga.RegistarCompanyActivity
import com.mezet.actaandroid.adapters.IzvjestajiAdapter
import com.mezet.actaandroid.adapters.UpravaFirmeAdapter
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.presenters.registar.StanjeRacunaPresenter
import com.mezet.actaandroid.presenters.registar.UpravaPresenter
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import kotlinx.android.synthetic.main.appbar_small.view.*
import kotlinx.android.synthetic.main.fragment_profil_kompanije.*

class StanjeRacunaFragment : Fragment(), CompanyByIdView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_stanje_racuna, container, false)

        val appbar_text =activity?.findViewById(R.id.appbar_pretraga_registar) as Toolbar
        appbar_text.back_btn_appbar.setOnClickListener(View.OnClickListener {
            back()
        })

        requireActivity().onBackPressedDispatcher.addCallback(
            viewLifecycleOwner,
            object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    back()
                }
            }
        )

        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId = 6058

        token?.let { StanjeRacunaPresenter(this).getClientCompanySR(companyId, it) }

        return v
    }
    fun back(){
        val intent = Intent (activity, RegistarCompanyActivity::class.java)
        intent.putExtra("open","vezane_firme")
        this.startActivity(intent)
    }

    override fun getCompany(clientCompany: CompanyPayload?) {
        val aktivni_racuni = view?.findViewById(R.id.textView178) as TextView
        val blokirani_racuni = view?.findViewById(R.id.textView179) as TextView
        val ugaseni_racuni = view?.findViewById(R.id.textView180) as TextView

        if(clientCompany?.BrojAktivnihRacunaIsVisible==false){
            aktivni_text.visibility=View.GONE
            aktivni_racuni.visibility=View.GONE
        }else{
            aktivni_racuni.text=clientCompany?.BrojAktivnihRacuna
        }
        if(clientCompany?.BrojBlokiranihRacunaIsVisible==false){
            blokirani_text.visibility=View.GONE
            blokirani_racuni.visibility=View.GONE
        }else{
            blokirani_racuni.text=clientCompany?.BrojBlokiranihRacuna
        }
        if(clientCompany?.BrojUgasenihRacunaIsVisible==false){
            ugaseni_text.visibility=View.GONE
            ugaseni_racuni.visibility=View.GONE
        }

        //stanje_glavnih

        val adapter =clientCompany?.let { context?.let { it1 ->
            IzvjestajiAdapter(it,
                it1,"glavni")
        } }
        val recyclerView = view?.findViewById(R.id.stanje_glavnih) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val adapter2 =clientCompany?.let { context?.let { it1 ->
            IzvjestajiAdapter(it,
                it1,"aktivni")
        } }
        val recyclerView2 = view?.findViewById(R.id.stanje_aktivnih) as RecyclerView
        recyclerView2.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView2.adapter = adapter2

        val adapter3 =clientCompany?.let { context?.let { it1 ->
            IzvjestajiAdapter(it,
                it1,"ugaseni")
        } }
        val recyclerView3 = view?.findViewById(R.id.stanje_ugasenih) as RecyclerView
        recyclerView3.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView3.adapter = adapter3
    }



}