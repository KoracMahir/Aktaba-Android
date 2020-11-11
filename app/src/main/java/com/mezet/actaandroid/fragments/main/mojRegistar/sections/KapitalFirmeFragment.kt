package com.mezet.actaandroid.fragments.main.mojRegistar.sections

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.pretraga.RegistarCompanyActivity
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.presenters.registar.KapitalFirmePresenter
import com.mezet.actaandroid.presenters.registar.VlasnickaStrukturaPresenter
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import kotlinx.android.synthetic.main.appbar_small.view.*

class KapitalFirmeFragment : Fragment(), CompanyByIdView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_kapital_firme, container, false)

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
        token?.let { KapitalFirmePresenter(this).getClientCompanyVl(companyId, it) }

        return v
    }

    fun back(){
        val intent = Intent (activity, RegistarCompanyActivity::class.java)
        intent.putExtra("open","vezane_firme")
        this.startActivity(intent)
    }

    override fun getCompany(companyPayload: CompanyPayload?) {
        val ukupno = view?.findViewById<TextView>(R.id.textView136)
        val unovcu = view?.findViewById<TextView>(R.id.textView137)
        val upravima = view?.findViewById<TextView>(R.id.textView130)
        val ustvarima = view?.findViewById<TextView>(R.id.ustvarima_text)

        ukupno?.text=companyPayload?.Kapital?.Capital_Total
        unovcu?.text=companyPayload?.Kapital?.Capital_in_money
        upravima?.text=companyPayload?.Kapital?.Capital_in_rights
        ustvarima?.text=companyPayload?.Kapital?.Capital_in_things
    }

}