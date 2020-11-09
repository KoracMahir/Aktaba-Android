package com.mezet.actaandroid.fragments.main.mojProfil.subsections

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.DjelatnostiAdapter
import com.mezet.actaandroid.adapters.PovezanaDrustvaAdapter
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.presenters.mojprofil.CompanyByIdPresenter
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView


class PovezanaDrustvaFragment : Fragment(),CompanyByIdView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId =sharedPref?.getInt("companyId",0)
        token?.let { companyId?.let { it1 -> CompanyByIdPresenter(this).getClientCompany(it1, it) } }
        return inflater.inflate(R.layout.fragment_povezana_drustva, container, false)
    }

    override fun getCompany(companyPayload: CompanyPayload?) {
        Log.d("ima ih",""+ companyPayload?.Povezana_Drustva?.size)
        val adapter =context?.let { companyPayload?.let { it1 -> PovezanaDrustvaAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.povezana_drustva_recycler) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

}