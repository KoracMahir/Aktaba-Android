package com.mezet.actaandroid.fragments.main.vijesti

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.VijestiAdapterOne
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.presenters.MostRecentNewsPresenter
import com.mezet.actaandroid.views.MostRecentNewsView
import kotlinx.android.synthetic.main.fragment_home2.*

class Pauza : Fragment(), MostRecentNewsView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_pauza, container, false)
        MostRecentNewsPresenter(this).getMostRecentFromAPI()

        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment
        val home = parent?.view?.findViewById(R.id.home_btn) as Button
        val vijesti = parent?.view?.findViewById(R.id.vijesti_btn) as Button
        val investicije = parent?.view?.findViewById(R.id.investicije_btn) as Button
        val kapital = parent?.view?.findViewById(R.id.kapital_btn) as Button
        val eu = parent?.view?.findViewById(R.id.eu_btn) as Button
        val najave = parent?.view?.findViewById(R.id.najave_btn) as Button
        val licnosti = parent?.view?.findViewById(R.id.licnosti_btn) as Button
        val karijera = parent?.view?.findViewById(R.id.karijera_btn) as Button
        val pauza = parent?.view?.findViewById(R.id.pauza_btn) as Button
        val kolumna = parent?.view?.findViewById(R.id.kolumna_btn) as Button
        val analiza = parent?.view?.findViewById(R.id.analize_btn) as Button

        val home_choosed = parent?.view?.findViewById(R.id.home_choosed) as ImageView
        val vijesti_choosed = parent?.view?.findViewById(R.id.vijesti_choosed) as ImageView
        val investicije_choosed = parent?.view?.findViewById(R.id.investicije_choosed) as ImageView
        val eu_choosed = parent?.view?.findViewById(R.id.eu_choosed) as ImageView
        val najave_choosed = parent?.view?.findViewById(R.id.najave_choosed) as ImageView
        val licnosti_choosed = parent?.view?.findViewById(R.id.licnosti_choosed) as ImageView
        val karijera_choosed = parent?.view?.findViewById(R.id.karijera_choosed) as ImageView
        val pauza_choosed = parent?.view?.findViewById(R.id.pauza_choosed) as ImageView
        val kolumna_choosed = parent?.view?.findViewById(R.id.kolumna_choosed) as ImageView
        val analiza_choosed = parent?.view?.findViewById(R.id.analiza_choosed) as ImageView
        val kapital_choosed = parent?.view?.findViewById(R.id.kapital_choosed) as ImageView

        home_choosed.visibility=View.GONE
        vijesti_choosed.visibility=View.GONE
        investicije_choosed.visibility=View.GONE
        kapital_choosed.visibility=View.GONE
        eu_choosed.visibility=View.GONE
        najave_choosed.visibility=View.GONE
        licnosti_choosed.visibility=View.GONE
        karijera_choosed.visibility=View.GONE
        pauza_choosed.visibility=View.VISIBLE
        kolumna_choosed.visibility=View.GONE
        analiza_choosed.visibility=View.GONE

        vijesti.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_vijesti)
        })

        eu.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_EU)
        })
        najave.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_najaves)
        })
        licnosti.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_licnosti)
        })
        karijera.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_karijera)
        })
        pauza.setOnClickListener(View.OnClickListener {
        })
        kolumna.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_kolumna)
        })
        analiza.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_analiza)
        })

        kapital.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_kapital)
        })

        home.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_homeFragment)
        })
        investicije.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_pauza_to_investicije)
        })

        return view
    }

    override fun onMostRecentNews(mostRecentNews: MostRecentNews?) {
        val adapter = context?.let { VijestiAdapterOne(mostRecentNews, it) }
        val recyclerView = view?.findViewById(R.id.najnovije_top) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter
    }

    override fun onFailiuer(string: String) {
        Toast.makeText(context,string, Toast.LENGTH_LONG).show()
    }

    override fun getContext(): Context? {
        return super.getContext()
    }

}