package com.mezet.actaandroid.fragments.main.mojProfil

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.CompaniesAdapter
import com.mezet.actaandroid.adapters.KompanijeKojePratimAdapter
import com.mezet.actaandroid.models.company.CompanyAutocompletePayload
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.kojepratim.KojePratimPayload
import com.mezet.actaandroid.models.mojprofil.ClientCompany
import com.mezet.actaandroid.presenters.mojprofil.CompanyAutoCompletePresenter
import com.mezet.actaandroid.presenters.mojprofil.KompanijeKojePratimPresenter
import com.mezet.actaandroid.views.mojprofil.CompanyAutoCompleteView
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import com.mezet.actaandroid.views.mojprofil.KompanijeKojePratimView
import com.mezet.actaandroid.views.mojprofil.ProfilKompanijeView
import kotlinx.android.synthetic.main.fragment_profil_pracenje.*


class ProfilPracenjeFragment : Fragment(),CompanyAutoCompleteView,KompanijeKojePratimView,CompanyByIdView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_profil_pracenje, container, false)
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
        pracenjekompanija_choosed.visibility=View.VISIBLE
        izdvojeno_choosed.visibility=View.GONE
        posaljiupit_choosed.visibility=View.GONE

        profilkorisnika_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilKorisnikaFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        profilkompanije_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilKompanijeFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        newsletter_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilNewsFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        pracenjekompanije_drawer.setOnClickListener(View.OnClickListener {
            drawer.closeDrawer(Gravity.LEFT)
        })
        izdvojeno_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilIzdvojenoFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })
        posaljiupit_drawer.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilUpitFragment)
            drawer.closeDrawer(Gravity.LEFT)
        })

        val profilkorisnika = parent?.view?.findViewById(R.id.profil_korisnika_btn) as Button
        val profilkompanije = parent?.view?.findViewById(R.id.profil_kompanije_btn) as Button
        val newsletter = parent?.view?.findViewById(R.id.newsletter_btn) as Button
        val pracenjekompanija = parent?.view?.findViewById(R.id.pracenjekompanija_btn) as Button
        val izdvojeno = parent?.view?.findViewById(R.id.izdvojeno_btn) as Button
        val posljiupit = parent?.view?.findViewById(R.id.posaljiupit_btn) as Button

        profilkorisnika.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilKorisnikaFragment)
        })
        profilkompanije.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilKompanijeFragment)
        })
        newsletter.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilNewsFragment)
        })
        pracenjekompanija.setOnClickListener(View.OnClickListener {
        })
        izdvojeno.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilIzdvojenoFragment)
        })
        posljiupit.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_profilPracenjeFragment_to_profilUpitFragment)
        })
        val edittext = v.findViewById(R.id.editTextTextPersonName3) as EditText
        edittext.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    CompanyAutoCompletePresenter(this@ProfilPracenjeFragment).getClientCompany(""+s)
                }
            }
        })
        val edittext2 = v.findViewById(R.id.editTextTextPersonName4) as EditText
        edittext2.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    CompanyAutoCompletePresenter(this@ProfilPracenjeFragment).getClientCompanyId(""+s)
                }
            }
        })
//        val recyclerView = v.findViewById(R.id.recycler_naziv_firme) as RecyclerView
//        val recyclerView2 = v.findViewById(R.id.recycler_id_firme) as RecyclerView
//        val close_name = v.findViewById(R.id.close_name) as View
//        val close_id = v.findViewById(R.id.close_id) as View
//
//        close_name.setOnClickListener(View.OnClickListener {
//            recyclerView.visibility=View.GONE
//        })
//        close_id.setOnClickListener(View.OnClickListener {
//            recyclerView2.visibility=View.GONE
//        })

        val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
        val token =sharedPref?.getString("token",null)
        val companyId =sharedPref?.getInt("companyId",0)

        token?.let { KompanijeKojePratimPresenter(this).getKojePratim(it) }

        return v
    }

    override fun getCompanyNames(autocompletePayload: CompanyAutocompletePayload?) {
        val adapter =autocompletePayload?.let { context?.let { it1 -> CompaniesAdapter(it, it1) } }
        val recyclerView = view?.findViewById(R.id.recycler_naziv_firme) as RecyclerView
        if (adapter != null) {
            Log.d("pozicijana", adapter.onPosition().toString())
        }
        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        val close = view?.findViewById<View>(R.id.onclose)
        close?.visibility=View.VISIBLE

        close?.setOnClickListener(View.OnClickListener {
            val edittext1 = view?.findViewById(R.id.editTextTextPersonName3) as EditText
            edittext1.setText(""+ adapter?.onPosition()?.let { it1 -> autocompletePayload?.get(it1)?.value })
            close.visibility=View.GONE
            recyclerView.visibility=View.GONE
            val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
            val token =sharedPref?.getString("token",null)
            val companyId =adapter?.onPosition()?.let { it1 -> autocompletePayload?.get(it1)?.id }
            companyId?.let { it1 -> token?.let { it2 ->
                CompanyAutoCompletePresenter(this).getCompany(it1,
                    it2
                )
            } }
        })
    }

    override fun getCompanyIds(autocompletePayload: CompanyAutocompletePayload?) {
        val adapter =autocompletePayload?.let { context?.let { it1 -> CompaniesAdapter(it, it1) } }
        val recyclerView = view?.findViewById(R.id.recycler_id_firme) as RecyclerView
        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
        val close_id = view?.findViewById(R.id.close_id) as View
        close_id.visibility=View.VISIBLE
        close_id.setOnClickListener(View.OnClickListener {
            val edittext = view?.findViewById(R.id.editTextTextPersonName4) as EditText
            edittext.setText(""+ adapter?.onPosition()?.let { it1 -> autocompletePayload?.get(it1)?.value })
            recyclerView.visibility=View.GONE
            val sharedPref: SharedPreferences?=activity?.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)
            val token =sharedPref?.getString("token",null)
            val companyId =adapter?.onPosition()?.let { it1 -> autocompletePayload?.get(it1)?.id }
            companyId?.let { it1 -> token?.let { it2 ->
                CompanyAutoCompletePresenter(this).getCompany(it1,
                    it2
                )
            } }
        })
    }

    override fun getKompanijeKojePratim(kojePratimPayload: KojePratimPayload?) {
        val adapter =context?.let { kojePratimPayload?.let { it1 -> KompanijeKojePratimAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.kompanije_koje_pratim_recycler) as RecyclerView
        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }



    override fun getCompany(companyPayload: CompanyPayload?) {
        val edittext = view?.findViewById(R.id.editTextTextPersonName4) as EditText
        edittext.setText(""+ companyPayload?.IdNumber)
        val edittext2 = view?.findViewById(R.id.editTextTextPersonName3) as EditText
        edittext2.setText(""+ companyPayload?.ShortName)
    }


}