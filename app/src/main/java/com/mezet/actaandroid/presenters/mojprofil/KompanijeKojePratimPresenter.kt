package com.mezet.actaandroid.presenters.mojprofil

import android.util.Log
import com.mezet.actaandroid.fragments.main.mojProfil.ProfilPracenjeFragment
import com.mezet.actaandroid.fragments.main.mojProfil.subsections.PovezanaDrustvaFragment
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.kojepratim.KojePratimPayload
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import com.mezet.actaandroid.views.mojprofil.KompanijeKojePratimView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KompanijeKojePratimPresenter(context: ProfilPracenjeFragment) {
    val profilkompanijeview = context as KompanijeKojePratimView

    fun getKojePratim(token:String) {
        RetrofitServices.create()
            .getFollowedKompanije(token)
            .enqueue(object:Callback<KojePratimPayload>{
                override fun onFailure(call: Call<KojePratimPayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<KojePratimPayload>,
                    response: Response<KojePratimPayload>
                ) {
                    Log.d("response",response.body().toString())
                    profilkompanijeview.getKompanijeKojePratim(response.body())
                }
            })
    }
}