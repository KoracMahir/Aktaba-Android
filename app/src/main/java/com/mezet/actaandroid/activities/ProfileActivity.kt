package com.mezet.actaandroid.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.ui.AppBarConfiguration
import com.diegodobelo.expandingview.ExpandingList
import com.google.android.material.navigation.NavigationView
import com.mezet.actaandroid.R
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.appbar
import kotlinx.android.synthetic.main.activity_main2.home_expand
import kotlinx.android.synthetic.main.activity_profile.*
import kotlinx.android.synthetic.main.activity_promo.*
import kotlinx.android.synthetic.main.appbar.view.*

class ProfileActivity : AppCompatActivity() {
    private var mExpandingList: ExpandingList? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        var opened = false

        val drawerLayout: DrawerLayout= findViewById(R.id.drawer_layout)

        val open=intent.getStringExtra("open")
        if(open=="true")
            opendrawer()

        val navView: NavigationView= findViewById(R.id.nav_view)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
//        drawerLayout.openDrawer(Gravity.LEFT) //open nav_drawer
        appbar.menu_1.setOnClickListener(View.OnClickListener {
            val drawerLayout: DrawerLayout= findViewById(R.id.drawer_layout)
            drawerLayout.openDrawer(Gravity.LEFT)
        })

        drawer_home_btn_profile.setOnClickListener(View.OnClickListener {
            if(home_expand.visibility== View.GONE)
                home_expand.visibility=View.VISIBLE
            else
                home_expand.visibility=View.GONE
        })
        drawer_vijesti_btn_profile.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, MainActivity::class.java)
            intent.putExtra("open","true")
            this.startActivity(intent)
        })
        drawer_registar_btn_profile.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, RegistarActivity::class.java)
            intent.putExtra("open","true")
            this.startActivity(intent)
        })
        drawer_tenderi_btn_profile.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, TenderiActivity::class.java)
            intent.putExtra("open","true")
            this.startActivity(intent)
        })
        drawer_promo_btn_profile.setOnClickListener(View.OnClickListener {
            val intent = Intent (this, PromoActivity::class.java)
            intent.putExtra("open","true")
            this.startActivity(intent)
        })
        drawer_profile_btn_profile.setOnClickListener(View.OnClickListener {
            if(profile_expand_.visibility== View.GONE)
                profile_expand_.visibility=View.VISIBLE
            else
                profile_expand_.visibility=View.GONE
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