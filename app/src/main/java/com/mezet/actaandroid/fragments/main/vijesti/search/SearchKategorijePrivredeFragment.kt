package com.mezet.actaandroid.fragments.main.vijesti.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.PrivredaAdapter
import com.mezet.actaandroid.adapters.PromoKategorijeAdapter
import com.mezet.actaandroid.models.privreda.PrivredaKategorije
import com.mezet.actaandroid.presenters.vijesti.PrivredaPresenter
import com.mezet.actaandroid.views.PrivredaView
import kotlinx.android.synthetic.main.appbar_small.view.*


class SearchKategorijePrivredeFragment : Fragment(),PrivredaView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_search_kategorije_privrede, container, false)

        val appbar_text =activity?.findViewById(R.id.appbar_pretraga) as Toolbar

        appbar_text.appbar_title_pretraga.text="KATEGORIJEPO GRANI PRIVREDE"
//        val title = appbar_text.findViewById<TextView>(R.id.appbar_title_pretraga)
//        title.text="TRAŽI"

        PrivredaPresenter(this).getKategorije()

        return v
    }

    override fun getPrivredaCategories(privredaKategorije: PrivredaKategorije?) {
        val adapter1 =context?.let { privredaKategorije?.let { it1 -> PrivredaAdapter(it1, it) } }
        val recyclerView1 = view?.findViewById(R.id.recycler_kategorije_promo) as RecyclerView
        recyclerView1.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView1.adapter = adapter1
    }


}