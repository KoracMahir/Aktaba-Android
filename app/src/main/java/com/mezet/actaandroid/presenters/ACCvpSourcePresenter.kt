package com.mezet.actaandroid.presenters

import android.util.Log
import com.mezet.actaandroid.fragments.main.vijesti.search.SearchFragment
import com.mezet.actaandroid.models.autocompletecountry.AutocompleteCountry
import com.mezet.actaandroid.models.cvp.CvpPayload
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.ACCountryView
import com.mezet.actaandroid.views.CVPSourceView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ACCvpSourcePresenter(context: SearchFragment) {
    val acCountryView = context as CVPSourceView

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

    fun getSources(term:String) {
        RetrofitServices.create()
            .getSourcesAutocomplete(term)
            .enqueue(object : Callback<CvpPayload> {
                override fun onFailure(call: Call<CvpPayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CvpPayload>,
                    response: Response<CvpPayload>
                ) {
                    Log.d("country12",response.body().toString())
                    acCountryView.getSources(response.body())
                }
            })
    }
}