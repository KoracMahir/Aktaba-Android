package com.mezet.actaandroid.fragments.main.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.BerzaAdapter
import com.mezet.actaandroid.adapters.KursnaListaAdapter
import com.mezet.actaandroid.models.kursnalista.KursnaLista
import com.mezet.actaandroid.presenters.vijesti.KursnaListaPresenter
import com.mezet.actaandroid.views.KursnaListaView


class KursnaListaFragment : Fragment(),KursnaListaView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_kursna_lista2, container, false)

        KursnaListaPresenter(this).getClientCompany()

        return v
    }

    override fun getKursnaLista(kursnaLista: KursnaLista?) {
        val adapter =context?.let { kursnaLista?.let { it1 -> KursnaListaAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.recycler_kursna) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

}