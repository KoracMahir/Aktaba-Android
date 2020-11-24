package com.mezet.actaandroid.fragments.main.vijesti.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.PrivredaAdapter
import com.mezet.actaandroid.adapters.VijestiKategorijeAdapter
import com.mezet.actaandroid.models.vijestikategorije.VijestiKategorije
import com.mezet.actaandroid.presenters.vijesti.VijestiKategorijePresenter
import com.mezet.actaandroid.views.VijestiKategorijeView
import kotlinx.android.synthetic.main.appbar_small.view.*


class SearchKategorijeFragment : Fragment(),VijestiKategorijeView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_search_kategorije, container, false)

        val appbar_text =activity?.findViewById(R.id.appbar_pretraga) as Toolbar

        appbar_text.appbar_title_pretraga.text="ODABIR KATEGORIJE VIJESTI"
//        val title = appbar_text.findViewById<TextView>(R.id.appbar_title_pretraga)
//        title.text="TRAŽI"

        VijestiKategorijePresenter(this).getKategorije()

        return v
    }

    override fun getKategorije(vijestiKategorije: VijestiKategorije?) {
        val adapter1 =context?.let { vijestiKategorije?.let { it1 -> VijestiKategorijeAdapter(it1, it) } }
        val recyclerView1 = view?.findViewById(R.id.recycler_kategorije_promo) as RecyclerView
        recyclerView1.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView1.adapter = adapter1
    }

}