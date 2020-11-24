package com.mezet.actaandroid.fragments.main.mojRegistar.sections

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Html
import android.util.Log
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
import com.mezet.actaandroid.presenters.registar.DrugiKontaktiPresenter
import com.mezet.actaandroid.presenters.registar.FinansijePresenter
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import kotlinx.android.synthetic.main.appbar_small.view.*


class DrugiKontaktiFragment : Fragment(), CompanyByIdView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_drugi_kontakti, container, false)

        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId = 7702

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

        token?.let { DrugiKontaktiPresenter(this).getClientCompanyDK(companyId, it) }

        return v
    }
    fun back(){
        val intent = Intent (activity, RegistarCompanyActivity::class.java)
        intent.putExtra("open","fin")
        this.startActivity(intent)
    }
    override fun getCompany(companyPayload: CompanyPayload?) {
        Log.d("toppodaci",companyPayload?.OtherContacts.toString())
        val text1 = view?.findViewById<TextView>(R.id.toppodaci)
        text1?.text = Html.fromHtml(companyPayload?.OtherContacts)
    }

}