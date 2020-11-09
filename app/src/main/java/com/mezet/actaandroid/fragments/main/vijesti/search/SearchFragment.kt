package com.mezet.actaandroid.fragments.main.vijesti.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.findNavController
import com.google.android.material.appbar.AppBarLayout
import com.mezet.actaandroid.R
import kotlinx.android.synthetic.main.appbar_small.view.*


class SearchFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_search, container, false)

        val appbar_text =activity?.findViewById(R.id.appbar_pretraga) as Toolbar

        appbar_text.appbar_title_pretraga.text="TRAŽI"
//        val title = appbar_text.findViewById<TextView>(R.id.appbar_title_pretraga)
//        title.text="ODABIR KATEGORIJE VIJESTI"

        val search_kat = v.findViewById<Button>(R.id.search_kategorije)
        search_kat.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchKategorijeFragment)
        })

        val search_privreda = v.findViewById<Button>(R.id.search_kategorije_privrede)
        search_privreda.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_searchFragment_to_searchKategorijePrivredeFragment)
        })

        return v
    }

}