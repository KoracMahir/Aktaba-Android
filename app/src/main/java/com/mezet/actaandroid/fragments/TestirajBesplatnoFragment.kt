package com.mezet.actaandroid.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.adapters.PovezanaDrustvaAdapter
import com.mezet.actaandroid.adapters.testiraj.TestirajItemAdapter
import com.mezet.actaandroid.models.testiraj_items.TestirajData
import com.mezet.actaandroid.presenters.vijesti.PacketDataPresenter
import com.mezet.actaandroid.views.PacketDataView


class TestirajBesplatnoFragment : Fragment(),PacketDataView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_testiraj_besplatno, container, false)

        val uporedi = v.findViewById(R.id.uporedi) as TextView
        uporedi.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_testirajBesplatnoFragment_to_uporediPaketeFragment)
        })

        PacketDataPresenter(this).getPacketData()

        return v
    }

    override fun getPacketData(testirajData: TestirajData?) {
        val adapter =context?.let { testirajData?.let { it1 -> TestirajItemAdapter(it1, it) } }
        val recyclerView = view?.findViewById(R.id.recycler_testiraj) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }


}