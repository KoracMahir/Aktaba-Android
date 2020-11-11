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
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.presenters.registar.OsnovniPodaciDodatnoPresenter
import com.mezet.actaandroid.presenters.registar.OsnovniPodaciPressPresenter
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView

class PressClippingFragment : Fragment(), CompanyByIdView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_press_clipping, container, false)

        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment

        val osnovni_choosed = parent?.view?.findViewById(R.id.osnovnipodaci_choosed) as ImageView
        val dodatni_choosed = parent?.view?.findViewById(R.id.dodatnipodaci_choosed) as ImageView
        val press_choosed = parent?.view?.findViewById(R.id.pressclipping_choosed) as ImageView

        val osnovni_btn = parent?.view?.findViewById(R.id.osnovnipodaci_btn) as Button
        val dodatni_btn = parent?.view?.findViewById(R.id.dodatnipodaci_btn) as Button
        val press_btn = parent?.view?.findViewById(R.id.pressclipping_btn) as Button

        osnovni_choosed.visibility=View.GONE
        dodatni_choosed.visibility=View.GONE
        press_choosed.visibility=View.VISIBLE

        osnovni_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pressClippingFragment_to_osnovniPodaciRegistarFragment)
        })
        dodatni_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pressClippingFragment_to_dodatniPodaciFragment)
        })
        press_btn.setOnClickListener(View.OnClickListener {

        })

        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId = 6058

        token?.let { OsnovniPodaciPressPresenter(this).getClientCompanyPress(companyId, it) }

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
    }

}