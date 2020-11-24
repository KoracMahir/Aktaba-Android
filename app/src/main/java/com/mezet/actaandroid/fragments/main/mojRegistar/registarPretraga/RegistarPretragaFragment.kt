package com.mezet.actaandroid.fragments.main.mojRegistar.registarPretraga

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.RegistarRezultatiActivity
import com.mezet.actaandroid.activities.pretraga.PretragaPromoActivity
import com.mezet.actaandroid.activities.pretraga.PretragaRegistarActivity
import com.mezet.actaandroid.activities.pretraga.RegistarCompanyActivity
import com.mezet.actaandroid.adapters.ACCountryAdapter
import com.mezet.actaandroid.adapters.ACCvpAdapter
import com.mezet.actaandroid.adapters.ACNameAdapter
import com.mezet.actaandroid.fragments.main.vijesti.search.SearchFragmentDirections
import com.mezet.actaandroid.models.autocompletecountry.AutocompleteCountry
import com.mezet.actaandroid.models.company.CompanyAutocompletePayload
import com.mezet.actaandroid.models.cvp.CvpPayload
import com.mezet.actaandroid.models.registarsearch.RegistarPayload
import com.mezet.actaandroid.presenters.registar.ACCountryRegPresenter
import com.mezet.actaandroid.presenters.registar.ACCvpRegPresenter
import com.mezet.actaandroid.presenters.registar.CompanyAutoCompleteRegPresenter
import com.mezet.actaandroid.presenters.registar.GetCompaniesCountPresenter
import com.mezet.actaandroid.presenters.vijesti.ACCountryPresenter
import com.mezet.actaandroid.views.ACCountryView
import com.mezet.actaandroid.views.CVPView
import com.mezet.actaandroid.views.GetCompaniesCountView
import com.mezet.actaandroid.views.RegistarPretragaView
import com.mezet.actaandroid.views.mojprofil.CompanyAutoCompleteView

class RegistarPretragaFragment : Fragment(),GetCompaniesCountView,
    ACCountryView, CVPView, CompanyAutoCompleteView {


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

        val firma_naziv = v.findViewById<EditText>(R.id.editTextTextPersonName12)
        val firma_id = v.findViewById<EditText>(R.id.editTextTextPersonName13)
        val menager = v.findViewById<EditText>(R.id.editTextTextPersonName14)
        val pojam_pretraga = v.findViewById<EditText>(R.id.editTextTextPersonName15)
        val teritory = v.findViewById<EditText>(R.id.editTextTextPersonName16)
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
            val intent = Intent (activity, RegistarRezultatiActivity::class.java)
            intent.putExtra("firma_naziv",""+firma_naziv.text)
            intent.putExtra("firma_id",""+""+firma_id.text)
            intent.putExtra("menager",""+menager.text)
            intent.putExtra("cpv_id",cpv_id)
            intent.putExtra("pojam_pretraga",""+pojam_pretraga.text)
            intent.putExtra("teritory",""+teritory.text)
            this.startActivity(intent)
//            val action1 = RegistarPretragaFragmentDirections.actionRegistarPretragaFragmentToRezultatiPretrageRegFragment2(
//                ""+firma_naziv.text,""+firma_id.text,""+menager.text,cpv_id,""+pojam_pretraga.text,""+teritory.text
//            )
//            view?.findNavController()?.navigate(action1)
            Log.d("pretrazujem:",""+firma_naziv.text+""+firma_id.text+""+menager.text+" "+pojam_pretraga.text+" "+teritory.text+" "+cpv_id)
        })
        GetCompaniesCountPresenter(this).getVijestiFromAPI()


        val country = v.findViewById<EditText>(R.id.editTextTextPersonName16)
        country.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    ACCountryRegPresenter(this@RegistarPretragaFragment).getClientCompany(""+s)
                }
            }
        })
        val company_name = v.findViewById<EditText>(R.id.editTextTextPersonName12)
        company_name.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    CompanyAutoCompleteRegPresenter(this@RegistarPretragaFragment).getClientCompanyName(""+s)
                }
            }
        })

        val id_pdv = v.findViewById<EditText>(R.id.editTextTextPersonName13)
        id_pdv.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    CompanyAutoCompleteRegPresenter(this@RegistarPretragaFragment).getClientCompanyId(""+s)
                }
            }
        })

        val cvp = v.findViewById<EditText>(R.id.editTextTextPersonName1a4)
        cvp.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    ACCvpRegPresenter(this@RegistarPretragaFragment).getCVPs(""+s)
                }
            }
        })

        return v
    }
    var cpv_id = 0
    override fun getCompaniesCount(count: Int?) {
        val count2 = view?.findViewById<TextView>(R.id.companies_count)
        count2?.text=count.toString()
    }

    override fun getCountryList(autocompleteCountry: AutocompleteCountry?) {
        //get list from country search
        val adapter =autocompleteCountry?.let { context?.let { it1 -> ACCountryAdapter(it, it1) } }
        val recyclerView = view?.findViewById(R.id.recycler_country_ac) as RecyclerView

        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val view1 = view?.findViewById<View>(R.id.onclose6)
        view1?.visibility=View.VISIBLE
        view1?.setOnClickListener(View.OnClickListener {
            val teritorija_edit = view?.findViewById<EditText>(R.id.editTextTextPersonName16)
            teritorija_edit?.setText(""+ adapter?.onPosition()?.let { it1 -> autocompleteCountry?.get(it1)?.TerritoryName })
            view1.visibility=View.GONE
            recyclerView.visibility=View.GONE
        })
    }

    override fun getCVP(cvpPayload: CvpPayload?) {
        //get list of cvps
        val adapter =context?.let { cvpPayload?.let { it1 -> ACCvpAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.recycler_djel_ac) as RecyclerView

        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val view1 = view?.findViewById<View>(R.id.onclose4)
        view1?.visibility=View.VISIBLE
        view1?.setOnClickListener(View.OnClickListener {
            val cvp = view?.findViewById<EditText>(R.id.editTextTextPersonName1a4)
            cvp?.setText(""+ adapter?.onPosition()?.let { it1 -> cvpPayload?.get(it1)?.value })
            cpv_id=adapter?.onPosition()?.let { it1 -> cvpPayload?.get(it1)?.id }!!
            view1.visibility=View.GONE
            recyclerView.visibility=View.GONE
        })
    }

    override fun getCompanyNames(autocompletePayload: CompanyAutocompletePayload?) {
        //get list of names searched by string
        val adapter =autocompletePayload?.let { context?.let { it1 -> ACNameAdapter(it, it1) } }
        val recyclerView = view?.findViewById(R.id.recycler_comp_name_ac) as RecyclerView

        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val view1 = view?.findViewById<View>(R.id.onclose)
        view1?.visibility=View.VISIBLE
        view1?.setOnClickListener(View.OnClickListener {
            val name = view?.findViewById<EditText>(R.id.editTextTextPersonName12)
            name?.setText(""+ adapter?.onPosition()?.let { it1 -> autocompletePayload?.get(it1)?.value })
            view1.visibility=View.GONE
            recyclerView.visibility=View.GONE
        })
    }

    override fun getCompanyIds(autocompletePayload: CompanyAutocompletePayload?) {
        //get list of names searched by id
        val adapter =autocompletePayload?.let { context?.let { it1 -> ACNameAdapter(it, it1) } }
        val recyclerView = view?.findViewById(R.id.recycler_id_ac) as RecyclerView

        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val view1 = view?.findViewById<View>(R.id.onclose2)
        view1?.visibility=View.VISIBLE
        view1?.setOnClickListener(View.OnClickListener {
            val id_edit = view?.findViewById<EditText>(R.id.editTextTextPersonName13)
            id_edit?.setText(""+ adapter?.onPosition()?.let { it1 -> autocompletePayload?.get(it1)?.value })
            view1.visibility=View.GONE
            recyclerView.visibility=View.GONE
        })
    }

}