package com.mezet.actaandroid.fragments.main.vijesti.search

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.MainActivity
import com.mezet.actaandroid.adapters.ACCountryAdapter
import com.mezet.actaandroid.adapters.ACCvpAdapter
import com.mezet.actaandroid.models.autocompletecountry.AutocompleteCountry
import com.mezet.actaandroid.models.cvp.CvpPayload
import com.mezet.actaandroid.presenters.ACCvpSourcePresenter
import com.mezet.actaandroid.presenters.vijesti.ACCountryPresenter
import com.mezet.actaandroid.views.ACCountryView
import com.mezet.actaandroid.views.CVPSourceView
import kotlinx.android.synthetic.main.appbar_small.view.*
import java.util.*


class SearchFragment : Fragment(),ACCountryView, DatePickerDialog.OnDateSetListener,CVPSourceView {

    @SuppressLint("ResourceAsColor")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_search, container, false)
        var drzave_choosed = ""
        val drzave = v.findViewById(R.id.editTextTextPersonName6) as TextView
        val drzave_exapnd = v.findViewById(R.id.linear) as LinearLayout

        drzave.setOnClickListener(View.OnClickListener {
            if(drzave_exapnd.visibility==View.GONE){
                drzave_exapnd.visibility=View.VISIBLE
            }else{
                drzave_exapnd.visibility=View.GONE
                drzave.text=drzave_choosed
            }
        })
        val sve = v.findViewById<TextView>(R.id.sve)
        val bih = v.findViewById<TextView>(R.id.bih)
        val ostale = v.findViewById<TextView>(R.id.ostale)

        sve.setOnClickListener(View.OnClickListener {
            drzave_choosed="Sve zemlje"
            sve.setTextColor(R.color.white)
            sve.setBackgroundResource(R.color.akta_blue)
            //
            ostale.setTextColor(R.color.akta_blue)
            ostale.setBackgroundResource(R.color.white)
            //
            bih.setTextColor(R.color.akta_blue)
            bih.setBackgroundResource(R.color.white)
        })
        bih.setOnClickListener(View.OnClickListener {
            drzave_choosed="BiH"
            bih.setTextColor(R.color.white)
            bih.setBackgroundResource(R.color.akta_blue)
            //
            ostale.setTextColor(R.color.akta_blue)
            ostale.setBackgroundResource(R.color.white)
            //
            sve.setTextColor(R.color.akta_blue)
            sve.setBackgroundResource(R.color.white)
        })
        ostale.setOnClickListener(View.OnClickListener {
            drzave_choosed="Ostale"
            ostale.setTextColor(R.color.white)
            ostale.setBackgroundResource(R.color.akta_blue)
            //
            bih.setTextColor(R.color.akta_blue)
            bih.setBackgroundResource(R.color.white)
            //
            sve.setTextColor(R.color.akta_blue)
            sve.setBackgroundResource(R.color.white)
        })

        val teritorija_edit = v.findViewById<EditText>(R.id.editTextTextPersonName7)
        teritorija_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    ACCountryPresenter(this@SearchFragment).getClientCompany(""+s,drzave_choosed)
                    Log.d("country13",""+s+' '+drzave_choosed)
                }
            }
        })

        val cvp_edit = v.findViewById<EditText>(R.id.editTextTextPersonName10)
        cvp_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    ACCvpSourcePresenter(this@SearchFragment).getCVPs(""+s)
                }
            }
        })


        val source_edit = v.findViewById<EditText>(R.id.editTextTextPersonName11)
        source_edit.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                Log.d("presao",""+count+" "+start+" "+before+" "+s)
                if(start>0){
                    ACCvpSourcePresenter(this@SearchFragment).getSources(""+s)
                }
            }
        })

        val vrati_na=activity?.intent?.getStringExtra("open")
        val pretraga = activity?.intent?.getStringExtra("zadnja_pretraga")

        Log.d("pretraga: ","search: "+pretraga)

        val appbar_text =activity?.findViewById(R.id.appbar_pretraga) as Toolbar
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


        appbar_text.appbar_title_pretraga.text="TRAŽI"
//        val title = appbar_text.findViewById<TextView>(R.id.appbar_title_pretraga)
//        title.text="ODABIR KATEGORIJE VIJESTI"
        val search_text = v.findViewById<EditText>(R.id.editTextTextPersonName5)
        appbar_text.appbar_title_pretraga.setOnClickListener(View.OnClickListener {

            val action = SearchFragmentDirections.actionSearchFragmentToVijestiRezultatiFragment(""+search_text.text)
            v.findNavController().navigate(action)
        })
        val search_kat = v.findViewById<Button>(R.id.search_kategorije)
        search_kat.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchKategorijeFragment)
        })

        val search_privreda = v.findViewById<Button>(R.id.search_kategorije_privrede)
        search_privreda.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchKategorijePrivredeFragment)
        })

        val od_date= v.findViewById<TextView>(R.id.editTextTextPersonName8)
        od_date.setOnClickListener(View.OnClickListener {
            choosed="od"
            val calendar: Calendar= Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                context?.let { it1 -> DatePickerDialog(it1, this, year, month,day) }
            datePickerDialog?.show()
        })

        val do_date= v.findViewById<TextView>(R.id.editTextTextPersonName9)
        do_date.setOnClickListener(View.OnClickListener {
            choosed="do"
            val calendar: Calendar= Calendar.getInstance()
            day = calendar.get(Calendar.DAY_OF_MONTH)
            month = calendar.get(Calendar.MONTH)
            year = calendar.get(Calendar.YEAR)
            val datePickerDialog =
                context?.let { it1 -> DatePickerDialog(it1, this, year, month,day) }
            datePickerDialog?.show()
        })

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val pretraga = activity?.intent?.getStringExtra("zadnja_pretraga")
        if(pretraga!=null){
            Log.d("pretraga: ",pretraga)

            val action1 = SearchFragmentDirections.actionSearchFragmentToVijestiRezultatiFragment(pretraga)
            view.findNavController().navigate(action1)
        }
    }

    fun back(){
        val intent = Intent (activity, MainActivity::class.java)
        this.startActivity(intent)
    }

    override fun getCountryList(autocompleteCountry: AutocompleteCountry?) {
        val adapter =autocompleteCountry?.let { context?.let { it1 -> ACCountryAdapter(it, it1) } }
        val recyclerView = view?.findViewById(R.id.recycler_country_ac) as RecyclerView

        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val view1 = view?.findViewById<View>(R.id.onclose)
        view1?.visibility=View.VISIBLE
        view1?.setOnClickListener(View.OnClickListener {
            val teritorija_edit = view?.findViewById<EditText>(R.id.editTextTextPersonName7)
            teritorija_edit?.setText(""+ adapter?.onPosition()?.let { it1 -> autocompleteCountry?.get(it1)?.TerritoryName })
            view1.visibility=View.GONE
            recyclerView.visibility=View.GONE
        })
    }
    var choosed = ""
    var day = 0
    var month: Int = 0
    var year: Int = 0
    var hour: Int = 0
    var minute: Int = 0
    var myDay = 0
    var myMonth: Int = 0
    var myYear: Int = 0
    var myHour: Int = 0
    var myMinute: Int = 0
    override fun onDateSet(view2: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        myDay = day
        myYear = year
        myMonth = month
        val calendar: Calendar = Calendar.getInstance()
//        val datePickerDialog =
//            context?.let { it1 -> DatePickerDialog(it1, this, myYear, myMonth,myDay) }
//        datePickerDialog?.show()
        Log.d("vrijeme",""+view2?.dayOfMonth+"."+view2?.month+"."+view2?.year)
        if(choosed=="od"){
            val od_date= view?.findViewById<TextView>(R.id.editTextTextPersonName8)
            od_date?.text=""+view2?.dayOfMonth+"."+view2?.month+"."+view2?.year
        }else{
            val do_date= view?.findViewById<TextView>(R.id.editTextTextPersonName9)
            do_date?.text=""+view2?.dayOfMonth+"."+view2?.month+"."+view2?.year
        }

    }

    override fun getCVP(cvpPayload: CvpPayload?) {
        val adapter =context?.let { cvpPayload?.let { it1 -> ACCvpAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.recycler_cvp_ac) as RecyclerView

        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val view1 = view?.findViewById<View>(R.id.onclose10)
        view1?.visibility=View.VISIBLE
        view1?.setOnClickListener(View.OnClickListener {
            val teritorija_edit = view?.findViewById<EditText>(R.id.editTextTextPersonName10)
            teritorija_edit?.setText(""+ adapter?.onPosition()?.let { it1 -> cvpPayload?.get(it1)?.value })
            view1.visibility=View.GONE
            recyclerView.visibility=View.GONE
        })
    }

    override fun getSources(cvpPayload: CvpPayload?) {
        val adapter =context?.let { cvpPayload?.let { it1 -> ACCvpAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.recycler_izvor_ac) as RecyclerView

        recyclerView.visibility=View.VISIBLE
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val view1 = view?.findViewById<View>(R.id.onclose11)
        view1?.visibility=View.VISIBLE
        view1?.setOnClickListener(View.OnClickListener {
            val teritorija_edit = view?.findViewById<EditText>(R.id.editTextTextPersonName11)
            teritorija_edit?.setText(""+ adapter?.onPosition()?.let { it1 -> cvpPayload?.get(it1)?.value })
            view1.visibility=View.GONE
            recyclerView.visibility=View.GONE
        })
    }


}