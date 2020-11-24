package com.mezet.actaandroid.fragments.main.vijesti.search

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.MainActivity
import com.mezet.actaandroid.activities.pretraga.PretragaVijestiActivity
import com.mezet.actaandroid.adapters.RezultatiVijestiAdapter
import com.mezet.actaandroid.models.Search
import com.mezet.actaandroid.models.rezultativijesti.RezultatiVijesti
import com.mezet.actaandroid.presenters.vijesti.RezultatiVijestiPresenter
import com.mezet.actaandroid.views.RezultatiVijestiView
import kotlinx.android.synthetic.main.appbar_small.view.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody


class VijestiRezultatiFragment : Fragment(),RezultatiVijestiView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_vijesti_rezultati, container, false)

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

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args =arguments?.let { VijestiRezultatiFragmentArgs.fromBundle(it) }
        val search_text = args?.searchText

        val search =search_text?.let { Search(it) }

        search?.let { RezultatiVijestiPresenter(this).getClientCompany(it) }
    }

    override fun getRezultati(vijesti: RezultatiVijesti?) {
        val args =arguments?.let { VijestiRezultatiFragmentArgs.fromBundle(it) }
        val search_text = args?.searchText
        Log.d("pretraga: ","rezultati: "+search_text)

        val adapter =context?.let { vijesti?.let { it1 -> search_text?.let { it2 ->
            RezultatiVijestiAdapter(it1, it,
                it2
            )
        } } }
        val recyclerView = view?.findViewById(R.id.recycler_rezultati_vijesti) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

    fun back(){
        val intent = Intent (activity, PretragaVijestiActivity::class.java)
        this.startActivity(intent)
    }

}