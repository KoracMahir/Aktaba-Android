package com.mezet.actaandroid.fragments.main.mojRegistar.rezultati

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.DjelatnostiAdapter2
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.presenters.registar.OsnovniPodaciPresenter
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import kotlinx.android.synthetic.main.fragment_profil_kompanije.*


class OsnovniPodaciRegistarFragment : Fragment(), CompanyByIdView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v=  inflater.inflate(R.layout.fragment_osnovni_podaci_registar, container, false)

        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment

        val osnovni_choosed = parent?.view?.findViewById(R.id.osnovnipodaci_choosed) as ImageView
        val dodatni_choosed = parent?.view?.findViewById(R.id.dodatnipodaci_choosed) as ImageView
        val press_choosed = parent?.view?.findViewById(R.id.pressclipping_choosed) as ImageView

        val osnovni_btn = parent?.view?.findViewById(R.id.osnovnipodaci_btn) as Button
        val dodatni_btn = parent?.view?.findViewById(R.id.dodatnipodaci_btn) as Button
        val press_btn = parent?.view?.findViewById(R.id.pressclipping_btn) as Button

        osnovni_choosed.visibility=View.VISIBLE
        dodatni_choosed.visibility=View.GONE
        press_choosed.visibility=View.GONE

        osnovni_btn.setOnClickListener(View.OnClickListener {

        })
        dodatni_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_osnovniPodaciRegistarFragment_to_dodatniPodaciFragment)
        })
        press_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_osnovniPodaciRegistarFragment_to_pressClippingFragment)
        })



        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId = 6058

        token?.let { OsnovniPodaciPresenter(this).getClientCompanyRegistar(companyId, it) }
        return v
    }


    override fun getCompany(clientCompany: CompanyPayload?) {
        val logo = view?.findViewById(R.id.logo_kompanija) as ImageView
        clientCompany?.LogoPath?.let { Log.d("logo_url", it) }
        Glide
            .with(this)
            .load(clientCompany?.LogoPath)
            .centerCrop()
            .into(logo)

        val short_name = view?.findViewById(R.id.short_name) as TextView
        val long_name = view?.findViewById(R.id.long_name) as TextView
        short_name.text=clientCompany?.ShortName
        long_name.text=clientCompany?.FullName

        val adresa = view?.findViewById(R.id.adresa) as TextView
        val zipplusgrad = view?.findViewById(R.id.zipcodepluscity) as TextView
        adresa.text=clientCompany?.Address
        zipplusgrad.text=clientCompany?.ZipCode+" "+clientCompany?.City

        val phone1 = view?.findViewById(R.id.phone1) as TextView
        val phone2 = view?.findViewById(R.id.phone2) as TextView
        val fax1 = view?.findViewById(R.id.fax1) as TextView

        phone1.text=clientCompany?.Phone?.substring(0,15)
        phone2.text=clientCompany?.Phone?.substring(21,36)
        fax1.text=clientCompany?.Fax

        val email = view?.findViewById(R.id.email_kompanije) as TextView
        val website = view?.findViewById(R.id.website) as TextView

        email.text=clientCompany?.Email
        website.text=clientCompany?.Web

        val menager_full_name = view?.findViewById(R.id.menager_full_name) as TextView
        menager_full_name.text=clientCompany?.ManagerFullName

        val ukupan_prihod = view?.findViewById(R.id.ukupan_prihod) as TextView
        val ukupan_prihod_text = view?.findViewById(R.id.ukupan_prihod_text) as TextView
        val broj_radnika = view?.findViewById(R.id.prosjecan_br_radnika) as TextView
        val broj_radnika_text = view?.findViewById(R.id.prosjecan_br_radnika_text) as TextView

        ukupan_prihod.text=clientCompany?.finansije?.get(0)?.UkupanPrihod.toString()
        ukupan_prihod_text.text="UKUPAN PRIOD U "+clientCompany?.finansije?.get(0)?.Godina.toString()+". GODINI"
        broj_radnika.text=clientCompany?.finansije?.get(0)?.BrojRadnika.toString()
        broj_radnika_text.text="PROSJEČAN BROJ  RADNIKA ("+clientCompany?.finansije?.get(0)?.Godina.toString()+".god)"

        val oblik_svojine = view?.findViewById(R.id.oblik_svojine) as TextView
        val id_broj = view?.findViewById(R.id.id_broj) as TextView
        val pdv_broj = view?.findViewById(R.id.pdv_broj) as TextView
        val datum_osnivanja = view?.findViewById(R.id.datum_osnivanja) as TextView
        val berzanski_index = view?.findViewById(R.id.berzanski_index) as TextView

        oblik_svojine.text=clientCompany?.OwnershipType
        id_broj.text=clientCompany?.IdNumber
        pdv_broj.text=clientCompany?.PdvNumber
        datum_osnivanja.text=clientCompany?.DateCreated
        berzanski_index.text=clientCompany?.StockIndex

        val aktivni_racuni = view?.findViewById(R.id.aktivni) as TextView
        val blokirani_racuni = view?.findViewById(R.id.blokirani) as TextView
        val ugaseni_racuni = view?.findViewById(R.id.ugaseni) as TextView

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

        val adapter =context?.let { clientCompany?.let { it1 -> DjelatnostiAdapter2(it1, it) } }
        val recyclerView = view?.findViewById(R.id.djelatnosti_recycler) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

}