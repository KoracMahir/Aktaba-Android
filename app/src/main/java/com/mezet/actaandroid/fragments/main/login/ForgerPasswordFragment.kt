package com.mezet.actaandroid.fragments.main.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.findNavController
import com.mezet.actaandroid.R

class ForgerPasswordFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_forger_password, container, false)

        val back_btn = v.findViewById(R.id.back_btn_forgetpassword) as TextView

        back_btn.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_forgerPasswordFragment_to_loginFragment)
        })
        return v
    }


}