package com.mezet.actaandroid.fragments.main.mojProfil

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.mojprofil.Client
import com.mezet.actaandroid.presenters.mojprofil.ProfilKorisnikaPresenter
import com.mezet.actaandroid.views.mojprofil.ProfilKorisnikaView
import java.text.SimpleDateFormat
import java.util.*


class ProfilKorisnikaFragment : Fragment(),ProfilKorisnikaView {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_profil_korisnika, container, false)

        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)

        token?.let { ProfilKorisnikaPresenter(this).getClientName(it) }
        token?.let { ProfilKorisnikaPresenter(this).getClientFax(it) }
        token?.let { ProfilKorisnikaPresenter(this).getCompanyId(it) }

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

        val profilkorisnika = parent?.view?.findViewById(R.id.profil_korisnika_btn) as Button
        val profilkompanije = parent?.view?.findViewById(R.id.profil_kompanije_btn) as Button
        val newsletter = parent?.view?.findViewById(R.id.newsletter_btn) as Button
        val pracenjekompanija = parent?.view?.findViewById(R.id.pracenjekompanija_btn) as Button
        val izdvojeno = parent?.view?.findViewById(R.id.izdvojeno_btn) as Button
        val posljiupit = parent?.view?.findViewById(R.id.posaljiupit_btn) as Button

        profilkorisnika.setOnClickListener(View.OnClickListener {
            drawer.closeDrawer(Gravity.LEFT)
        })
        profilkompanije.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilKompanijeFragment)
        })
        newsletter.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilNewsFragment)
        })
        pracenjekompanija.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilPracenjeFragment)
        })
        izdvojeno.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilIzdvojenoFragment)
        })
        posljiupit.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilUpitFragment)
        })

        profilkorisnika_choosed.visibility=View.VISIBLE
        profilkompanije_choosed.visibility=View.GONE
        newsletter_choosed.visibility=View.GONE
        pracenjekompanija_choosed.visibility=View.GONE
        izdvojeno_choosed.visibility=View.GONE
        posaljiupit_choosed.visibility=View.GONE

        profilkorisnika_drawer.setOnClickListener(View.OnClickListener {
            drawer.closeDrawer(Gravity.LEFT)
        })
        profilkompanije_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilKompanijeFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        newsletter_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilNewsFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        pracenjekompanije_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilPracenjeFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        izdvojeno_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilIzdvojenoFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        posaljiupit_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilKorisnikaFragment_to_profilUpitFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })



        return v
    }

    override fun getClient(client: Client?) {


        val fullname = view?.findViewById(R.id.fullname_profil) as TextView
        fullname.text=client?.FullName
        val mail = view?.findViewById(R.id.email_profil) as TextView
        mail.text=client?.Email
        val status = view?.findViewById(R.id.title_profile) as TextView
        status.text=client?.Status
        val paket = view?.findViewById(R.id.paket_profil) as TextView
        paket.text=client?.Paket
        val vazido = view?.findViewById(R.id.vazido_profil) as TextView
        vazido.text=client?.ValidTo?.substring(8,10)+"."+client?.ValidTo?.substring(5,7)+"."+client?.ValidTo?.substring(0,4)


        val checkbox_premium = view?.findViewById(R.id.premium_checkbox) as CheckBox
        if(client?.Paket=="Premium")
            checkbox_premium.isChecked=true

        val brojdana = view?.findViewById(R.id.brojdana_profil) as TextView
        val date: Date=Date()
        val day_now=date.day
        val month_now=date.month
        val year_now=date.toString().substring(30,34).toInt()

        val day_vazi =client?.ValidTo?.substring(8,10)?.toInt()
        val month_vazi = client?.ValidTo?.substring(5,7)?.toInt()
        val year_vazi = client?.ValidTo?.substring(0,4)?.toInt()

        val date_now = ""+year_now+"-"+month_now+"-"+day_now+" 12:56:50"
        val date_vazi = ""+year_vazi+"-"+month_vazi+"-"+day_vazi+" 12:56:50"

        val dateFormat=SimpleDateFormat(
            "yyyy-MM-dd HH:mm:ss"
        )
        val now =dateFormat.parse(date_now)
        val vazi =dateFormat.parse(date_vazi)

        val diff = vazi.time-now.time
        val seconds: Long=diff / 1000
        val minutes=seconds / 60
        val hours=minutes / 60
        val days=hours / 24

        Log.d("datum", ""+date.day+"."+date.month+"."+date.toString().substring(30,34))
        Log.d("datum",""+now+" "+vazi+"vazi do: "+days)
        Log.d("datum",""+date_now+" "+date_vazi+"vazi do: "+days)
        brojdana.text=""+days
    }

    override fun getClientFax(fax: String) {
        Log.d("podaci",fax)
        val numm = view?.findViewById(R.id.fax_profile) as TextView
        numm.text=fax.subSequence(0,15)
    }

    override fun getCompanyId(id: Int) {
        val editor: SharedPreferences.Editor?=activity?.getSharedPreferences("MY_PREFS_NAME",
            Context.MODE_PRIVATE
        )?.edit()
        editor?.putInt("companyId", id)
        editor?.apply()
    }

}