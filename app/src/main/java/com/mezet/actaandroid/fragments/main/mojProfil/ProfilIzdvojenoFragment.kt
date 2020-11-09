package com.mezet.actaandroid.fragments.main.mojProfil

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.DjelatnostiAdapter
import com.mezet.actaandroid.adapters.IzdvojenoAdapter
import com.mezet.actaandroid.models.izdvojeni.IzdvojenoPayload
import com.mezet.actaandroid.presenters.mojprofil.IzdvojenoPresenter
import com.mezet.actaandroid.views.mojprofil.IzdvojenoView

class ProfilIzdvojenoFragment : Fragment(),IzdvojenoView {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_profil_izdvojeno, container, false)
        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment

        val drawer =activity?.findViewById(R.id.drawer_layout) as DrawerLayout
        val profilkorisnika_drawer = activity?.findViewById(R.id.profilkorisnika_drawer) as TextView
        val profilkompanije_drawer = activity?.findViewById(R.id.profilkompanije_drawer) as TextView
        val newsletter_drawer = activity?.findViewById(R.id.newsletter_drawer) as TextView
        val pracenjekompanije_drawer = activity?.findViewById(R.id.pracenjekompanija_drawer) as TextView
        val izdvojeno_drawer = activity?.findViewById(R.id.izdvojeno_drawer) as TextView
        val posaljiupit_drawer = activity?.findViewById(R.id.posaljiupit_drawer) as TextView

        val profilkorisnika_choosed = parent?.view?.findViewById(R.id.profil_korisnika_choosed) as ImageView
        val profilkompanije_choosed = parent?.view?.findViewById(R.id.profil_kompanije_choosed) as ImageView
        val newsletter_choosed = parent?.view?.findViewById(R.id.newsletter_choosed) as ImageView
        val pracenjekompanija_choosed = parent?.view?.findViewById(R.id.pracenjekompanija_choosed) as ImageView
        val izdvojeno_choosed = parent?.view?.findViewById(R.id.izdvojeno_choosed) as ImageView
        val posaljiupit_choosed = parent?.view?.findViewById(R.id.posaljiupit_choosed) as ImageView

        profilkorisnika_choosed.visibility=View.GONE
        profilkompanije_choosed.visibility=View.GONE
        newsletter_choosed.visibility=View.GONE
        pracenjekompanija_choosed.visibility=View.GONE
        izdvojeno_choosed.visibility=View.VISIBLE
        posaljiupit_choosed.visibility=View.GONE

        profilkorisnika_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilKorisnikaFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        profilkompanije_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilKompanijeFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        newsletter_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilNewsFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        pracenjekompanije_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilPracenjeFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        izdvojeno_drawer.setOnClickListener(View.OnClickListener {
            drawer.closeDrawer(Gravity.LEFT)
        })
        posaljiupit_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilUpitFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })

        val profilkorisnika = parent?.view?.findViewById(R.id.profil_korisnika_btn) as Button
        val profilkompanije = parent?.view?.findViewById(R.id.profil_kompanije_btn) as Button
        val newsletter = parent?.view?.findViewById(R.id.newsletter_btn) as Button
        val pracenjekompanija = parent?.view?.findViewById(R.id.pracenjekompanija_btn) as Button
        val izdvojeno = parent?.view?.findViewById(R.id.izdvojeno_btn) as Button
        val posljiupit = parent?.view?.findViewById(R.id.posaljiupit_btn) as Button

        profilkorisnika.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilKorisnikaFragment)
        })
        profilkompanije.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilKompanijeFragment)
        })
        newsletter.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilNewsFragment)
        })
        pracenjekompanija.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilPracenjeFragment)
        })
        izdvojeno.setOnClickListener(View.OnClickListener {
        })
        posljiupit.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilIzdvojenoFragment_to_profilUpitFragment)
        })

        val tenderi = v.findViewById(R.id.tenderi_izdvojeno) as Button
        val clanci = v.findViewById(R.id.clanci_izdvojeno) as Button
        val promo = v.findViewById(R.id.promo_izdvojeno) as Button

        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        token?.let { IzdvojenoPresenter(this).getClientCompany(it) }
        tenderi.setOnClickListener(View.OnClickListener {
            tenderi.setTextColor(Color.WHITE)
            clanci.setTextColor(Color.parseColor("#5294E2"))
            promo.setTextColor(Color.parseColor("#5294E2"))
            choosed="tenderi"
            token?.let { IzdvojenoPresenter(this).getClientCompany(it) }
            tenderi.setBackgroundResource(R.color.akta_blue)
            clanci.setBackgroundResource(R.drawable.okvir_plava)
            promo.setBackgroundResource(R.drawable.okvir_plava)
        })
        clanci.setOnClickListener(View.OnClickListener {
            tenderi.setTextColor(Color.parseColor("#5294E2"))
            clanci.setTextColor(Color.WHITE)
            promo.setTextColor(Color.parseColor("#5294E2"))
            choosed="clanci"
            token?.let { IzdvojenoPresenter(this).getClientCompany(it) }
            tenderi.setBackgroundResource(R.drawable.okvir_plava)
            clanci.setBackgroundResource(R.color.akta_blue)
            promo.setBackgroundResource(R.drawable.okvir_plava)
        })
        promo.setOnClickListener(View.OnClickListener {
            tenderi.setTextColor(Color.parseColor("#5294E2"))
            clanci.setTextColor(Color.parseColor("#5294E2"))
            promo.setTextColor(Color.WHITE)
            choosed="promo"
            token?.let { IzdvojenoPresenter(this).getClientCompany(it) }
            tenderi.setBackgroundResource(R.drawable.okvir_plava)
            clanci.setBackgroundResource(R.drawable.okvir_plava)
            promo.setBackgroundResource(R.color.akta_blue)
        })


        return v
    }
    var choosed = "tenderi"
    override fun getIzdvojeno(izdvojenoPayload: IzdvojenoPayload?) {
        val adapter =context?.let { izdvojenoPayload?.let { it1 ->
            IzdvojenoAdapter(choosed,
                it1, it)
        } }
        val recyclerView = view?.findViewById(R.id.izdvojeno_recycler) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

}