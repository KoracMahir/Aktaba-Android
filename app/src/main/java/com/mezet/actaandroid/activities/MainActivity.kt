package com.mezet.actaandroid.activities

import android.os.Bundle
import android.view.Gravity
import android.view.Menu
import android.view.View
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.navigation.NavigationView
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.diegodobelo.expandingview.ExpandingItem
import com.diegodobelo.expandingview.ExpandingList
import com.mezet.actaandroid.R
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity : AppCompatActivity() {
    private var mExpandingList: ExpandingList? = null
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
//        val toolbar: Toolbar = findViewById(R.id.toolbar)
//        setSupportActionBar(toolbar)



        mExpandingList = findViewById(R.id.expanding_list_main)
        createItems()

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow), drawerLayout)
//        setupActionBarWithNavController(navController, appBarConfiguration)
//        drawerLayout.openDrawer(Gravity.LEFT) //open nav_drawer
        navView.setupWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.home, menu)
        return true
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
    private fun createItems() {
        addItem("HOME", arrayOf("Konvertor valuta", "Berza", "Kursna lista", "Kreditni kalkulator"),
            R.color.home
        )
        addItem("VIJESTI", arrayOf("Vijesti", "Investiciji", "Kapital", "EU","Najave","Ličnosti","Karijera","Kolumna","Pauza","Analize"),
            R.color.vijesti
        )
        addItem("REGISTAR", arrayOf("Kompanije i institucije"),
            R.color.registar
        )
        addItem("TENDERI", arrayOf("Dodjela ugovora","Objavi tender","Legistlativa"),
            R.color.tenderi
        )
        addItem("PROMO", arrayOf("Kategorije oglasa","Objavi oglas"),
            R.color.promo
        )
        addItem("MOJ PROFIL", arrayOf("Porfil korisnika","Profil kompanije","Newsletter","Praćenje kompanija","Izdvojeno","Pošalji upit"),
            R.color.profile
        )
        addItem("O AKTI", arrayOf("Nagrade i priznanja","Izvještaj o radu","Kontakti"),
            R.color.promo
        )
        addItem("ODJAVI SE", arrayOf(), R.color.registar)
    }

    private fun addItem(title: String, subItems: Array<String>, colorRes: Int) {
        //Let's create an item with R.layout.expanding_layout
        val item = mExpandingList!!.createNewItem(R.layout.expanding_layout)

        //If item creation is successful, let's configure it
        if (item != null) {
            (item.findViewById(R.id.pozadina) as View).setBackgroundResource(colorRes)
            //It is possible to get any view inside the inflated layout. Let's set the text in the item
            (item.findViewById(R.id.title) as TextView).text = title

            //We can create items in batch.
            item.createSubItems(subItems.size)
            for (i in 0 until item.subItemsCount) {
                //Let's get the created sub item by its index
                val view = item.getSubItemView(i)

                //Let's set some values in
                configureSubItem(item, view, subItems[i])
            }
        }
    }

    private fun configureSubItem(item: ExpandingItem?, view: View, subTitle: String) {
        (view.findViewById(R.id.sub_title) as TextView).text = subTitle
    }



    internal interface OnItemCreated {
        fun itemCreated(title: String)
    }
}