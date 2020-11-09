package com.mezet.actaandroid.fragments.main.mojProfil

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.mezet.actaandroid.R
import com.mezet.actaandroid.presenters.mojprofil.UpitPresenter


class ProfilUpitFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_profil_upit, container, false)
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
        izdvojeno_choosed.visibility=View.GONE
        posaljiupit_choosed.visibility=View.VISIBLE

        profilkorisnika_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilKorisnikaFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        profilkompanije_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilKompanijeFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        newsletter_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilNewsFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        pracenjekompanije_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilPracenjeFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        izdvojeno_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilIzdvojenoFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        posaljiupit_drawer.setOnClickListener(View.OnClickListener {
            drawer.closeDrawer(Gravity.LEFT)
        })

        val profilkorisnika = parent?.view?.findViewById(R.id.profil_korisnika_btn) as Button
        val profilkompanije = parent?.view?.findViewById(R.id.profil_kompanije_btn) as Button
        val newsletter = parent?.view?.findViewById(R.id.newsletter_btn) as Button
        val pracenjekompanija = parent?.view?.findViewById(R.id.pracenjekompanija_btn) as Button
        val izdvojeno = parent?.view?.findViewById(R.id.izdvojeno_btn) as Button
        val posljiupit = parent?.view?.findViewById(R.id.posaljiupit_btn) as Button

        profilkorisnika.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilKorisnikaFragment)
        })
        profilkompanije.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilKompanijeFragment)
        })
        newsletter.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilNewsFragment)
        })
        pracenjekompanija.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilPracenjeFragment)
        })
        izdvojeno.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilUpitFragment_to_profilIzdvojenoFragment)
        })
        posljiupit.setOnClickListener(View.OnClickListener {
        })

        val upit = v.findViewById(R.id.upit_text) as EditText
        val btn= v.findViewById(R.id.posalji_upit) as Button
        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        btn.setOnClickListener(View.OnClickListener {
            token?.let { it1 -> UpitPresenter(this).getClientName(""+upit.text, it1) }
        })

        return v
    }

}