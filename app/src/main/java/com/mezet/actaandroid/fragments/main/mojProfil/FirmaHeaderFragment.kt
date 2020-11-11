package com.mezet.actaandroid.fragments.main.mojProfil

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.presenters.registar.OsnovniPodaciHeader
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView


class FirmaHeaderFragment : Fragment(), CompanyByIdView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_firma_header, container, false)

        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId = 6058

        token?.let { OsnovniPodaciHeader(this).getClientCompanyHeader(companyId, it) }

        return v
    }

    override fun getCompany(clientCompany: CompanyPayload?) {
        val logo = view?.findViewById(R.id.logo_kompanija_h) as ImageView?
        clientCompany?.LogoPath?.let { Log.d("logo_url", it) }
        logo?.let {
            Glide
                .with(this)
                .load(clientCompany?.LogoPath)
                .centerCrop()
                .into(it)
        }

        val short_name = view?.findViewById(R.id.short_name_h) as TextView?
        val long_name = view?.findViewById(R.id.long_name_h) as TextView?
        short_name?.text=clientCompany?.ShortName
        long_name?.text=clientCompany?.FullName

        val adresa = view?.findViewById(R.id.adresa_h) as TextView?
        val zipplusgrad = view?.findViewById(R.id.zipcodepluscity_h) as TextView?
        adresa?.text=clientCompany?.Address
        zipplusgrad?.text=clientCompany?.ZipCode+" "+clientCompany?.City

        val phone1 = view?.findViewById(R.id.phone1_h) as TextView?
        val phone2 = view?.findViewById(R.id.phone2_h) as TextView?
        val fax1 = view?.findViewById(R.id.fax1_h) as TextView?

        phone1?.text=clientCompany?.Phone?.substring(0,15)
        phone2?.text=clientCompany?.Phone?.substring(21,36)
        fax1?.text=clientCompany?.Fax

        val email = view?.findViewById(R.id.email_kompanije_h) as TextView?
        val website = view?.findViewById(R.id.website_h) as TextView?

        email?.text=clientCompany?.Email
        website?.text=clientCompany?.Web
    }

}