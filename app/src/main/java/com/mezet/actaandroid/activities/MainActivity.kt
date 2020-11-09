package com.mezet.actaandroid.activities

import android.app.PendingIntent.getActivity
import android.content.Intent
import android.opengl.Visibility
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.core.view.get
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import androidx.navigation.ui.AppBarConfiguration
import com.diegodobelo.expandingview.ExpandingItem
import com.diegodobelo.expandingview.ExpandingList
import com.google.android.material.navigation.NavigationView
import com.mezet.actaandroid.R
import com.mezet.actaandroid.activities.pretraga.PretragaVijestiActivity
import com.mezet.actaandroid.fragments.sections.NajaveFragment
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.appbar.view.*
import kotlinx.android.synthetic.main.expanding_layout.*
import kotlinx.android.synthetic.main.fragment_testiraj_besplatno.*


class MainActivity : AppCompatActivity() {
    private var mExpandingList: ExpandingList? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        var opened = false

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)

        val open=intent.getStringExtra("open")
        if(open=="true")
            opendrawer()

        val navView: NavigationView = findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
//        drawerLayout.openDrawer(Gravity.LEFT) //open nav_drawer
        appbar_vijesti.menu_1.setOnClickListener(View.OnClickListener {
            val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
            drawerLayout.openDrawer(Gravity.LEFT)
        })
        appbar_vijesti.search_btn.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, PretragaVijestiActivity::class.java)
            intent.putExtra("opened","vijesti")
            this.startActivity(intent)
        })

        drawer_home_btn_vijesti.setOnClickListener(View.OnClickListener {
            if(home_expand.visibility==View.GONE)
                home_expand.visibility=View.VISIBLE
            else
                home_expand.visibility=View.GONE
        })
        drawer_vijesti_btn_vijesti.setOnClickListener(View.OnClickListener {
            if(vijesti_expand.visibility==View.GONE)
                vijesti_expand.visibility=View.VISIBLE
            else
                vijesti_expand.visibility=View.GONE
        })
        drawer_registar_btn_vijesti.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, RegistarActivity::class.java)
            intent.putExtra("open","true")
            this.startActivity(intent)
        })
        drawer_tenderi_btn_vijesti.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, TenderiActivity::class.java)
            intent.putExtra("open","true")
            this.startActivity(intent)
        })
        drawer_promo_btn_vijesti.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, PromoActivity::class.java)
            intent.putExtra("open","true")
            this.startActivity(intent)
        })
        drawer_profile_btn_vijesti.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, ProfileActivity::class.java)
            intent.putExtra("open","true")
            this.startActivity(intent)
        })
        drawer_odjavise_btn_vijesti.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, LoginActivity::class.java)
            intent.putExtra("open_from","vijesti")
            this.startActivity(intent)
        })

    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    fun opendrawer(){
        val drawerLayout: DrawerLayout= findViewById(R.id.drawer_layout)
        drawerLayout.openDrawer(Gravity.LEFT)
    }





}


