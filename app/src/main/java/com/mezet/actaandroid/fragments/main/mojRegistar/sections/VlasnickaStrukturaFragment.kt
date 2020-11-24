package com.mezet.actaandroid.fragments.main.mojRegistar.sections

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.navigation.fragment.findNavController
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.presenters.registar.OsnovniPodaciHeader
import com.mezet.actaandroid.presenters.registar.VlasnickaStrukturaPresenter
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView


class VlasnickaStrukturaFragment : Fragment(), CompanyByIdView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_vlasnicka_struktura, container, false)

        val open=activity?.intent?.getStringExtra("open")
        if(open=="kapital")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_kapitalFirmeFragment)
        else if(open=="finansije")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_finansijeRegistarFragment)
        else if(open=="uprava")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_upravaRegistarFragment)
        else if(open=="stanje_racuna")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_stanjeRacunaFragment)
        else if(open=="opis_djelatnosti")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_opisDjelatnostiFragment)
        else if(open=="drugi_kontakti")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_drugiKontaktiFragment)
        else if(open=="robne_marke")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_robneMarkeFragment)
        else if(open=="robe_i_usluge")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_robneUslugeFragment)
        else if(open=="tenderi")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_objavljeniTenderiFragment)
        else if(open=="ucescenatenderima")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_ucesceNaTenderimaFragment)
        else if(open=="pobjede_na_tenderima")
            findNavController().navigate(R.id.action_vlasnickaStrukturaFragment_to_pobjedeNaTenderimaFragment)
        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId = 6058



        token?.let { VlasnickaStrukturaPresenter(this).getClientCompanyVl(companyId, it) }

        return v
    }

    override fun getCompany(companyPayload: CompanyPayload?) {
        val fullname = view?.findViewById<TextView>(R.id.textView134)
        val ugovoreni = view?.findViewById<TextView>(R.id.textView136)
        val uplaceni =view?.findViewById<TextView>(R.id.textView137)
        val unovcu = view?.findViewById<TextView>(R.id.textView130)

        fullname?.text=companyPayload?.Owners?.get(0)?.Fullname
        ugovoreni?.text=companyPayload?.Owners?.get(0)?.Capital_Deal
        uplaceni?.text=companyPayload?.Owners?.get(0)?.Capital_Pay
        unovcu?.text =companyPayload?.Owners?.get(0)?.Capital_in_money
    }

}