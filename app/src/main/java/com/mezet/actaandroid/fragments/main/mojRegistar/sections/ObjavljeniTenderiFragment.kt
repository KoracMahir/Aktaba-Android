package com.mezet.actaandroid.fragments.main.mojRegistar.sections

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.pretraga.RegistarCompanyActivity
import com.mezet.actaandroid.adapters.ObjavljeniTenderiAdapter
import com.mezet.actaandroid.adapters.UpravaFirmeAdapter
import com.mezet.actaandroid.models.publishedtenders.PublishedTenders
import com.mezet.actaandroid.presenters.registar.DrugiKontaktiPresenter
import com.mezet.actaandroid.presenters.registar.ObjavljeniTenderiPresenter
import com.mezet.actaandroid.views.ObjavljeniTenderiView
import kotlinx.android.synthetic.main.appbar_small.view.*

class ObjavljeniTenderiFragment : Fragment(),ObjavljeniTenderiView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_objavljeni_tenderi, container, false)

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

        val page = 1
        token?.let { ObjavljeniTenderiPresenter(this).getObjavljeniTenderi(companyId,page,"", it) }
        return v
    }
    fun back(){
        val intent = Intent (activity, RegistarCompanyActivity::class.java)
        intent.putExtra("open","fin")
        this.startActivity(intent)
    }

    override fun getObjavljeni(publishedTenders: PublishedTenders?) {
        val adapter =context?.let { publishedTenders?.let { it1 -> ObjavljeniTenderiAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.recycler_objavljni_tenderi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

}