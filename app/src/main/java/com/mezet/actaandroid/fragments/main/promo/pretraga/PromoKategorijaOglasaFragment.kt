package com.mezet.actaandroid.fragments.main.promo.pretraga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toolbar
import com.mezet.actaandroid.R
import kotlinx.android.synthetic.main.appbar_small.view.*


class PromoKategorijaOglasaFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_promo_kategorija_oglasa, container, false)
        val appbar_text =activity?.findViewById(R.id.appbar_pretraga_promo) as Toolbar

        appbar_text.appbar_title_pretraga.text="ODABIR KATEGORIJE VIJESTI"
        return v
    }

}