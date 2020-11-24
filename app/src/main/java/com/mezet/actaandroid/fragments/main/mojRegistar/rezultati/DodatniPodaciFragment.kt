package com.mezet.actaandroid.fragments.main.mojRegistar.rezultati

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.pretraga.PretragaRegistarActivity
import com.mezet.actaandroid.activities.pretraga.RegistarCompanyActivity
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.presenters.registar.OsnovniPodaciDodatnoPresenter
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView


class DodatniPodaciFragment : Fragment(), CompanyByIdView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_dodatni_podaci, container, false)


        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment

        val osnovni_choosed = parent?.view?.findViewById(R.id.osnovnipodaci_choosed) as ImageView
        val dodatni_choosed = parent?.view?.findViewById(R.id.dodatnipodaci_choosed) as ImageView
        val press_choosed = parent?.view?.findViewById(R.id.pressclipping_choosed) as ImageView

        val osnovni_btn = parent?.view?.findViewById(R.id.osnovnipodaci_btn) as Button
        val dodatni_btn = parent?.view?.findViewById(R.id.dodatnipodaci_btn) as Button
        val press_btn = parent?.view?.findViewById(R.id.pressclipping_btn) as Button

        osnovni_choosed.visibility=View.GONE
        dodatni_choosed.visibility=View.VISIBLE
        press_choosed.visibility=View.GONE

        osnovni_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_dodatniPodaciFragment_to_osnovniPodaciRegistarFragment)
        })
        dodatni_btn.setOnClickListener(View.OnClickListener {

        })
        press_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_dodatniPodaciFragment_to_pressClippingFragment)
        })



        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId = 6058

        token?.let { OsnovniPodaciDodatnoPresenter(this).getClientCompanyRegistar(companyId, it) }


        val vlasnickastruktura = v.findViewById<TextView>(R.id.vlasnicka_struktura_dodatno)
        vlasnickastruktura.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","vlasnicka_struktura")
            this.startActivity(intent)
        })

        val kapital = v.findViewById<TextView>(R.id.kapital_dodatno)
        kapital.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","kapital")
            this.startActivity(intent)
        })
        val uprava = v.findViewById<TextView>(R.id.uprava_dodatno)
        uprava.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","uprava")
            this.startActivity(intent)
        })
        val stanjeracuna = v.findViewById<TextView>(R.id.stanje_racuna_dodatno)
        stanjeracuna.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","stanje_racuna")
            this.startActivity(intent)
        })
        val finansije = v.findViewById<TextView>(R.id.finansije_dodatno)
        finansije.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","finansije")
            this.startActivity(intent)
        })
        val opisdjelatnosti = v.findViewById<TextView>(R.id.opis_djelatnosti_dodatno)
        opisdjelatnosti.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","opis_djelatnosti")
            this.startActivity(intent)
        })
        val drugikontakti = v.findViewById<TextView>(R.id.drugi_kontakti_dodatno)
        drugikontakti.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","drugi_kontakti")
            this.startActivity(intent)
        })
        val robnemarke = v.findViewById<TextView>(R.id.robne_marke_dodatno)
        robnemarke.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","robne_marke")
            this.startActivity(intent)
        })
        val robeiusluge = v.findViewById<TextView>(R.id.robeiusluge_dodatno)
        robeiusluge.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","robe_i_usluge")
            this.startActivity(intent)
        })
        val tenderi_ = v.findViewById<TextView>(R.id.tenderi_dodatno)
        tenderi_.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","tenderi")
            this.startActivity(intent)
        })
        val ucescenatenderima = v.findViewById<TextView>(R.id.ucescenatenderima_dodatno)
        ucescenatenderima.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","ucescenatenderima")
            this.startActivity(intent)
        })
        val isporucioci = v.findViewById<TextView>(R.id.isporucioci_dodatno)
        isporucioci.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","isporucioci")
            this.startActivity(intent)
        })
        val stecajnipostupak = v.findViewById<TextView>(R.id.stecajnipostupak_dodatno)
        stecajnipostupak.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","stecajni_postupak")
            this.startActivity(intent)
        })
        val likvidacionipostupak = v.findViewById<TextView>(R.id.likvidaocionipostupak_dodatno)
        likvidacionipostupak.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","likvidacioni_postupak")
            this.startActivity(intent)
        })
        val pobjedenatenderima = v.findViewById<TextView>(R.id.pobjedenatenderima_dodatno)
        pobjedenatenderima.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","pobjede_na_tenderima")
            this.startActivity(intent)
        })
        val plannabavki = v.findViewById<TextView>(R.id.plannabavki_dodatno)
        plannabavki.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","plan_nabavki")
            this.startActivity(intent)
        })
        val vezanefirme = v.findViewById<TextView>(R.id.vezanefirme_dodatno)
        vezanefirme.setOnClickListener(View.OnClickListener {
            val intent = Intent (activity, PretragaRegistarActivity::class.java)
            intent.putExtra("open","vezane_firme")
            this.startActivity(intent)
        })

        return v
    }

    override fun getCompany(clientCompany: CompanyPayload?) {
        val logo = view?.findViewById(R.id.logo_kompanija) as ImageView
        clientCompany?.LogoPath?.let { Log.d("logo_url", it) }
        Glide
            .with(this)
            .load(clientCompany?.LogoPath)
            .centerCrop()
            .into(logo)

        val short_name = view?.findViewById(R.id.short_name) as TextView
        val long_name = view?.findViewById(R.id.long_name) as TextView
        short_name.text=clientCompany?.ShortName
        long_name.text=clientCompany?.FullName

        val adresa = view?.findViewById(R.id.adresa) as TextView
        val zipplusgrad = view?.findViewById(R.id.zipcodepluscity) as TextView
        adresa.text=clientCompany?.Address
        zipplusgrad.text=clientCompany?.ZipCode+" "+clientCompany?.City

        val phone1 = view?.findViewById(R.id.phone1) as TextView
        val phone2 = view?.findViewById(R.id.phone2) as TextView
        val fax1 = view?.findViewById(R.id.fax1) as TextView

        phone1.text=clientCompany?.Phone?.substring(0,15)
        phone2.text=clientCompany?.Phone?.substring(21,36)
        fax1.text=clientCompany?.Fax

        val email = view?.findViewById(R.id.email_kompanije) as TextView
        val website = view?.findViewById(R.id.website) as TextView

        email.text=clientCompany?.Email
        website.text=clientCompany?.Web
    }

}