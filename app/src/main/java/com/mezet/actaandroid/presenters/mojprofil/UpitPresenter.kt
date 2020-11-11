package com.mezet.actaandroid.presenters.mojprofil

import android.util.Log
import com.mezet.actaandroid.fragments.main.mojProfil.ProfilKorisnikaFragment
import com.mezet.actaandroid.fragments.main.mojProfil.ProfilUpitFragment
import com.mezet.actaandroid.models.UpitPayload
import com.mezet.actaandroid.models.mojprofil.ClientProfile
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.mojprofil.ProfilKorisnikaView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpitPresenter (context: ProfilUpitFragment) {
    fun getClientName(comment: String,token:String) {
        RetrofitServices.create()
            .sendUpit(comment,token)
            .enqueue(object : Callback<UpitPayload>{
                override fun onFailure(call: Call<UpitPayload>, t: Throwable) {

                }

                override fun onResponse(call: Call<UpitPayload>, response: Response<UpitPayload>) {
                    Log.d("upit","poslao se")
                }
            })
    }
}