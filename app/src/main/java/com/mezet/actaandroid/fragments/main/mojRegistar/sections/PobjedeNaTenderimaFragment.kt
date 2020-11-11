package com.mezet.actaandroid.fragments.main.mojRegistar.sections

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mezet.actaandroid.R

class PobjedeNaTenderimaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_pobjede_na_tenderima, container, false)

        return v
    }

}