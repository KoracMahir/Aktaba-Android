package com.mezet.actaandroid.fragments.main

import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.mezet.actaandroid.R
import kotlinx.android.synthetic.main.activity_main2.*


class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_home2, container, false)

//        val drawer =activity?.findViewById(R.id.drawer_layout) as DrawerLayout
//        val vijesti = activity?.findViewById(R.id.drawer_vijesti_btn) as Button
//        val promo = activity?.findViewById(R.id.kapital_drawer) as TextView
//        val promo = activity?.findViewById<View>(R.id.drawer_promo_btn) as Button
//        val parent: Fragment? = (parentFragment as NavHostFragment).parentFragment
//        val promo = parent?.view?.findViewById(R.id.drawer_promo_btn) as Button

//        Toast.makeText(context,"PROMO"+promo,Toast.LENGTH_LONG).show()


        return v
    }
    fun openEU(){
        Log.d("lista","EU")
    }
    fun openNajave(){
        Log.d("lista","NAJAVE")
    }
}
