package com.mezet.actaandroid.presenters.registar

import android.util.Log
import com.mezet.actaandroid.fragments.main.mojRegistar.registarPretraga.RegistarPretragaFragment
import com.mezet.actaandroid.fragments.main.vijesti.search.SearchFragment
import com.mezet.actaandroid.models.cvp.CvpPayload
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.CVPSourceView
import com.mezet.actaandroid.views.CVPView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ACCvpRegPresenter(context: RegistarPretragaFragment) {
    val acCountryView = context as CVPView

    fun getCVPs(term:String) {
        RetrofitServices.create()
            .getCvpsAutocomplete(term)
            .enqueue(object : Callback<CvpPayload> {
                override fun onFailure(call: Call<CvpPayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CvpPayload>,
                    response: Response<CvpPayload>
                ) {
                    Log.d("country12",response.body().toString())
                    acCountryView.getCVP(response.body())
                }
            })
    }
}