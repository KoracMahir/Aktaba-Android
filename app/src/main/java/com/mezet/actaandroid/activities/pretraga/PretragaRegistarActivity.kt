package com.mezet.actaandroid.activities.pretraga

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import com.mezet.actaandroid.R

class PretragaRegistarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pretraga_registar)

        val appbar = findViewById<Toolbar>(R.id.appbar_pretraga_registar)
        appbar.setBackgroundColor(Color.parseColor("#00B496"))
    }
}