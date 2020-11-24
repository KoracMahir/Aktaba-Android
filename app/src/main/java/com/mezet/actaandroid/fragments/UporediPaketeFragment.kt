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
import com.mezet.actaandroid.adapters.testiraj.TestirajItemAdapter
import com.mezet.actaandroid.adapters.testiraj.UporediAdapter
import com.mezet.actaandroid.models.testiraj_items.TestirajData
import com.mezet.actaandroid.presenters.vijesti.UporediPresenter
import com.mezet.actaandroid.views.PacketDataView
import org.w3c.dom.Text


class UporediPaketeFragment : Fragment(), PacketDataView {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_uporedi_pakete, container, false)

        UporediPresenter(this).getPacketData()

        return v
    }

    override fun getPacketData(testirajData: TestirajData?) {
        val option1 =testirajData?.get(0)?.options
        val option2 =testirajData?.get(1)?.options
        val option3 =testirajData?.get(2)?.options
        val option4 =testirajData?.get(3)?.options
        val option5 =testirajData?.get(4)?.options
        val option6 =testirajData?.get(5)?.options
        val adapter=context?.let {
            option6?.let { it1 ->
                option5?.let { it2 ->
                    option4?.let { it3 ->
                        option3?.let { it4 ->
                            option2?.let { it5 ->
                                option1?.let { it6 ->
                                    UporediAdapter(
                                        it6, it5, it4, it3, it2, it1,
                                        it
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
        val recyclerView = view?.findViewById(R.id.recycler_uporedi) as RecyclerView
        recyclerView.layoutManager= LinearLayoutManager(context,
            LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = adapter
    }

}