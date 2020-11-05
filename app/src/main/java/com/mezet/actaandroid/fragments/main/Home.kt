package com.mezet.actaandroid.fragments.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.mezet.actaandroid.R

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home2, container, false)

        val home_btn = v.findViewById(R.id.home_btn) as Button
        val vijesti_btn = v.findViewById(R.id.vijesti_btn) as Button
        val investicije_btn = v.findViewById(R.id.investicije_btn) as Button

        return v
    }

}