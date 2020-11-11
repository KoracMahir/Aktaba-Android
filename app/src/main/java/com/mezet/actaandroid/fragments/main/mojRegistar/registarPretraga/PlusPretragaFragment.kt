package com.mezet.actaandroid.fragments.main.mojRegistar.registarPretraga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.mezet.actaandroid.R

class PlusPretragaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_plus_pretraga, container, false)
        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment

        val pretraga_choosed = parent?.view?.findViewById(R.id.pretraga_choosed) as ImageView
        val premium_choosed = parent?.view?.findViewById(R.id.premium_choosed) as ImageView
        val plus_choosed = parent?.view?.findViewById(R.id.plus_choosed) as ImageView

        val pretraga_btn = parent?.view?.findViewById(R.id.pretraga_btn) as Button
        val premium_btn = parent?.view?.findViewById(R.id.premium_btn) as Button
        val plus_btn = parent?.view?.findViewById(R.id.plus_btn) as Button

        pretraga_choosed.visibility=View.GONE
        premium_choosed.visibility=View.GONE
        plus_choosed.visibility=View.VISIBLE

        pretraga_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_plusPretragaFragment_to_registarPretragaFragment)
        })
        premium_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_plusPretragaFragment_to_premiumPretragaFragment)
        })
        plus_btn.setOnClickListener(View.OnClickListener {

        })

        return v
    }

}