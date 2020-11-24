package com.mezet.actaandroid.activities

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.mezet.actaandroid.R
import kotlinx.android.synthetic.main.appbar_small.view.*

class JedinstvenaVijestActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jedinstvena_vijest)

        val appbar = findViewById<Toolbar>(R.id.appbar_jedinstvena)
//        appbar.appbar_title_pretraga.text="TRAŽI"
    }
}