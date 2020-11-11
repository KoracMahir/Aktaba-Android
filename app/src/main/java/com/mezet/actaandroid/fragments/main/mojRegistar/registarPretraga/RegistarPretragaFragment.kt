package com.mezet.actaandroid.fragments.main.mojRegistar.registarPretraga

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.pretraga.PretragaPromoActivity
import com.mezet.actaandroid.activities.pretraga.PretragaRegistarActivity
import com.mezet.actaandroid.activities.pretraga.RegistarCompanyActivity
import com.mezet.actaandroid.presenters.registar.GetCompaniesCountPresenter
import com.mezet.actaandroid.views.GetCompaniesCountView

class RegistarPretragaFragment : Fragment(),GetCompaniesCountView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_registar_pretraga, container, false)
        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment

        val pretraga_choosed = parent?.view?.findViewById(R.id.pretraga_choosed) as ImageView
        val premium_choosed = parent?.view?.findViewById(R.id.premium_choosed) as ImageView
        val plus_choosed = parent?.view?.findViewById(R.id.plus_choosed) as ImageView

        val pretraga_btn = parent?.view?.findViewById(R.id.pretraga_btn) as Button
        val premium_btn = parent?.view?.findViewById(R.id.premium_btn) as Button
        val plus_btn = parent?.view?.findViewById(R.id.plus_btn) as Button

        pretraga_choosed.visibility=View.VISIBLE
        premium_choosed.visibility=View.GONE
        plus_choosed.visibility=View.GONE

        pretraga_btn.setOnClickListener(View.OnClickListener {

        })
        premium_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_registarPretragaFragment_to_premiumPretragaFragment)
        })
        plus_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_registarPretragaFragment_to_plusPretragaFragment)
        })

        val trazi = v.findViewById<Button>(R.id.trazi_pretraga)
        trazi.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, RegistarCompanyActivity::class.java)
            intent.putExtra("opened","registar")
            this.startActivity(intent)
        })
        GetCompaniesCountPresenter(this).getVijestiFromAPI()
        return v
    }

    override fun getCompaniesCount(count: Int?) {
        val count2 = view?.findViewById<TextView>(R.id.companies_count)
        count2?.text=count.toString()
    }

}