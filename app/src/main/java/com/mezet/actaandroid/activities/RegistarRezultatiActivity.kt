package com.mezet.actaandroid.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mezet.actaandroid.R
import com.mezet.actaandroid.models.registarsearch.RegistarPayload
import com.mezet.actaandroid.presenters.registar.RegistarPretragaPresenter
import com.mezet.actaandroid.views.RegistarPretragaView

class RegistarRezultatiActivity : AppCompatActivity(), RegistarPretragaView {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registar_rezultati)

        val firma_naziv=intent.getStringExtra("firma_naziv")
        val firma_id=intent.getStringExtra("firma_id")
        val menager=intent.getStringExtra("menager")
        val cpv_id=intent.getIntExtra("cpv_id",0)
        val pojam_pretraga=intent.getStringExtra("pojam_pretraga")
        val teritory=intent.getStringExtra("teritory")
//
//        val registar = Registar(firma_naziv,firma_id,menager,cpv_id,pojam_pretraga,teritory)

//
//        RegistarPretragaPresenter(this).getClientCompanyFin()
    }

    override fun getCompaniesData(registarPayload: RegistarPayload?) {
        TODO("Not yet implemented")
    }
}