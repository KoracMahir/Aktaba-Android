package com.mezet.actaandroid.fragments.main.vijesti

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.*
import com.mezet.actaandroid.adapters.BerzaAdapter
import com.mezet.actaandroid.adapters.VijestiAdapterOne
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.presenters.MostRecentNewsPresenter
import com.mezet.actaandroid.views.MostRecentNewsView


class HomeFragment : Fragment(),MostRecentNewsView {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view : View = inflater.inflate(R.layout.fragment_home, container, false)
//        val v_host : View = inflater.inflate(R.layout.fragment_home2, container, false)
        MostRecentNewsPresenter(this).getMostRecentFromAPI()

        val prefs: SharedPreferences?=this.activity?.getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE)
        val name=
            prefs?.getString("screen", "HOME") //"No name defined" is the default value.


        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment

        val drawer =activity?.findViewById(R.id.drawer_layout) as DrawerLayout
        val vijesit_drawer = activity?.findViewById(R.id.vijesti_drawer) as TextView
        val investicije_drawer = activity?.findViewById(R.id.investicije_drawer) as TextView
        val kapital_drawer = activity?.findViewById(R.id.kapital_drawer) as TextView
        val eu_drawer = activity?.findViewById(R.id.eu_drawer) as TextView
        val najave_drawer = activity?.findViewById(R.id.najave_drawer) as TextView
        val licnosti_drawer = activity?.findViewById(R.id.licnosti_drawer) as TextView
        val karijera_drawer = activity?.findViewById(R.id.karijera_drawer) as TextView
        val kolumna_drawer = activity?.findViewById(R.id.kolumna_drawer) as TextView
        val pauza_drawer = activity?.findViewById(R.id.pauza_drawer) as TextView
        val analiza_drawer = activity?.findViewById(R.id.analize_drawer) as TextView
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

        home_choosed.visibility=View.VISIBLE
        vijesti_choosed.visibility=View.GONE
        investicije_choosed.visibility=View.GONE
        kapital_choosed.visibility=View.GONE
        eu_choosed.visibility=View.GONE
        najave_choosed.visibility=View.GONE
        licnosti_choosed.visibility=View.GONE
        karijera_choosed.visibility=View.GONE
        pauza_choosed.visibility=View.GONE
        kolumna_choosed.visibility=View.GONE
        analiza_choosed.visibility=View.GONE

        val home_drawer = activity?.findViewById(R.id.home_vijesti) as TextView
        val kursna_lista = activity?.findViewById(R.id.kursnalista_vijesti) as TextView
        val berza = activity?.findViewById(R.id.berza_vijesti) as TextView
        val konvertor = activity?.findViewById(R.id.konvertorvaluta_vijesti) as TextView
        val kalkulator = activity?.findViewById(R.id.kreditnikalkulator_vijesti) as TextView

        kursna_lista.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, MainActivity::class.java)
            this.startActivity(intent)
        })

        kursna_lista.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, KursnaListaActivity::class.java)
            this.startActivity(intent)
        })

        berza.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, BerzaActivity::class.java)
            this.startActivity(intent)
        })
        konvertor.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, KonvertorValutaActivity::class.java)
            this.startActivity(intent)
        })
        kalkulator.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, KreditniKalkulatroActivity::class.java)
            this.startActivity(intent)
        })


        vijesit_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_vijesti)
            drawer.closeDrawer(Gravity.LEFT)
        })
        investicije_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_investicije)
            drawer.closeDrawer(Gravity.LEFT)
        })
        kapital_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_kapital)
            drawer.closeDrawer(Gravity.LEFT)
        })
        eu_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_EU)
            drawer.closeDrawer(Gravity.LEFT)
        })
        najave_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_najaves)
            drawer.closeDrawer(Gravity.LEFT)
        })
        licnosti_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_licnosti)
            drawer.closeDrawer(Gravity.LEFT)
        })
        karijera_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_karijera)
            drawer.closeDrawer(Gravity.LEFT)
        })
        kolumna_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_kolumna)
            drawer.closeDrawer(Gravity.LEFT)
        })
        pauza_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pauza)
            drawer.closeDrawer(Gravity.LEFT)
        })
        analiza_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_analiza)
            drawer.closeDrawer(Gravity.LEFT)
        })

        home.setOnClickListener(View.OnClickListener {
        })

        eu.setOnClickListener(View.OnClickListener {
            goEU()
        })
        najave.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_najaves)
        })
        licnosti.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_licnosti)
        })
        karijera.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_karijera)
        })
        pauza.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_pauza)
        })
        kolumna.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_kolumna)
        })
        analiza.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_analiza)
        })

        kapital.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_kapital)
        })

        vijesti.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_vijesti)
        })
        investicije.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_investicije)
        })



        return view
    }
    fun goEU(){
        findNavController().navigate(R.id.action_homeFragment_to_EU)
    }


    override fun onMostRecentNews(mostRecentNews: MostRecentNews?) {
        val adapter = context?.let { VijestiAdapterOne(mostRecentNews, it) }
        val recyclerView = view?.findViewById(R.id.najnovije_top) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        recyclerView.adapter = adapter
    }

    override fun onFailiuer(string: String) {
        Toast.makeText(context,string,Toast.LENGTH_LONG).show()
    }


}