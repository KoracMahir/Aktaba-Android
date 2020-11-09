package com.mezet.actaandroid.fragments.main.mojRegistar.registarPretraga

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import com.mezet.actaandroid.R

class RegistarPretragaFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v= inflater.inflate(R.layout.fragment_registar_pretraga, container, false)
        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment


        val drawer =activity?.findViewById(R.id.drawer_layout) as DrawerLayout
        val pretraga_drawer = activity?.findViewById(R.id.pretraga_btn) as TextView
        val premium_drawer = activity?.findViewById(R.id.premium_btn) as TextView
        val plus_drawer = activity?.findViewById(R.id.plus_btn) as TextView

        val pretraga_choosed = parent?.view?.findViewById(R.id.pretraga_choosed) as ImageView
        val premium_choosed = parent?.view?.findViewById(R.id.premium_choosed) as ImageView
        val plus_choosed = parent?.view?.findViewById(R.id.plus_choosed) as ImageView

        return v
    }

}