package com.mezet.actaandroid.fragments.main.login

import android.content.Context.MODE_PRIVATE
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.MainActivity
import com.mezet.actaandroid.presenters.LoginPresenter
import com.mezet.actaandroid.views.LoginView


class LoginFragment : Fragment(),LoginView {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val v = inflater.inflate(R.layout.fragment_login, container, false)

        val zaboravio_sifru = v.findViewById(R.id.zaboravili_ste_sifru) as TextView
        val back_btn = v.findViewById(R.id.back_btn_login) as Button
        val prijava_btn = v.findViewById(R.id.prijava_btn) as Button

        val uname = v.findViewById(R.id.email_login) as EditText
        val password = v.findViewById(R.id.password_login) as EditText
        zaboravio_sifru.setOnClickListener(View.OnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_forgerPasswordFragment)
        })

        val open=activity?.intent?.getStringExtra("open_from")
        back_btn.setOnClickListener(View.OnClickListener {
            if(open=="vijesti"){
                val intent = Intent (activity, MainActivity::class.java)
                this.startActivity(intent)

            }
        })
        prijava_btn.setOnClickListener(View.OnClickListener {
            LoginPresenter(this).goLogin(""+uname.text,""+password.text)

        })
        return v
    }

    override fun onLoginSuccess(token: String) {
        val editor: SharedPreferences.Editor?=activity?.getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE)?.edit()
        editor?.putString("token", token)
        editor?.apply()
        val intent = Intent (activity, MainActivity::class.java)
        this.startActivity(intent)
    }

    override fun onLoginFailiure(message: String) {
        Toast.makeText(activity,""+message,Toast.LENGTH_LONG).show()
    }

}