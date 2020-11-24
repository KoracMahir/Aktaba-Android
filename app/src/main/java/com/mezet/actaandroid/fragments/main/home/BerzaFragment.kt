package com.mezet.actaandroid.fragments.main.home

import android.graphics.Color
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.BerzaAdapter
import com.mezet.actaandroid.models.berza.Berza
import com.mezet.actaandroid.presenters.vijesti.BerzaPresenter
import com.mezet.actaandroid.views.BerzaView


class BerzaFragment : Fragment(),BerzaView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_berza, container, false)

        BerzaPresenter(this).getClientCompany()

        return v
    }

    override fun getBerza(berza: Berza?) {
        val adapter =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"sase","win") } }
        val recyclerView = view?.findViewById(R.id.recycler_rast) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter

        val adapter1 =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"sase","lose") } }
        val recyclerView1 = view?.findViewById(R.id.recycler_pad) as RecyclerView
        recyclerView1.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView1.adapter = adapter1

        val adapter2 =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"sase","turnover") } }
        val recyclerView2 = view?.findViewById(R.id.recycler_promet) as RecyclerView
        recyclerView2.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView2.adapter = adapter2

        val blse = view?.findViewById<Button>(R.id.blse_btn)
        val sase = view?.findViewById<Button>(R.id.sase_btn)

        blse?.setOnClickListener(View.OnClickListener {
            blse.setBackgroundColor(Color.parseColor("#5294E2"))
            blse.setTextColor(Color.WHITE)
            sase?.setBackgroundResource(R.drawable.okvir_plava)
            sase?.setTextColor(Color.parseColor("#5294E2"))
            val adapter =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"blse","win") } }
            val recyclerView = view?.findViewById(R.id.recycler_rast) as RecyclerView
            recyclerView.layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
            recyclerView.adapter = adapter

            val adapter1 =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"blse","lose") } }
            val recyclerView1 = view?.findViewById(R.id.recycler_pad) as RecyclerView
            recyclerView1.layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
            recyclerView1.adapter = adapter1

            val adapter2 =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"blse","turnover") } }
            val recyclerView2 = view?.findViewById(R.id.recycler_promet) as RecyclerView
            recyclerView2.layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
            recyclerView2.adapter = adapter2
        })
        sase?.setOnClickListener(View.OnClickListener {
            sase.setBackgroundColor(Color.parseColor("#5294E2"))
            sase.setTextColor(Color.WHITE)
            blse?.setBackgroundResource(R.drawable.okvir_plava)
            blse?.setTextColor(Color.parseColor("#5294E2"))
            val adapter =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"sase","win") } }
            val recyclerView = view?.findViewById(R.id.recycler_rast) as RecyclerView
            recyclerView.layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
            recyclerView.adapter = adapter

            val adapter1 =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"sase","lose") } }
            val recyclerView1 = view?.findViewById(R.id.recycler_pad) as RecyclerView
            recyclerView1.layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
            recyclerView1.adapter = adapter1

            val adapter2 =context?.let { berza?.let { it1 -> BerzaAdapter(it1, it,"sase","turnover") } }
            val recyclerView2 = view?.findViewById(R.id.recycler_promet) as RecyclerView
            recyclerView2.layoutManager= LinearLayoutManager(context,
                LinearLayoutManager.VERTICAL,false)
            recyclerView2.adapter = adapter2
        })
    }


}