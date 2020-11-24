package com.mezet.actaandroid.presenters.registar

import android.util.Log
import com.mezet.actaandroid.fragments.main.mojRegistar.registarPretraga.RegistarPretragaFragment
import com.mezet.actaandroid.fragments.main.vijesti.search.SearchFragment
import com.mezet.actaandroid.models.autocompletecountry.AutocompleteCountry
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.ACCountryView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ACCountryRegPresenter(context: RegistarPretragaFragment) {
    val acCountryView = context as ACCountryView

    fun getClientCompany(term:String) {
        RetrofitServices.create()
            .getCountryAutocomplete2(term)
            .enqueue(object : Callback<AutocompleteCountry> {
                override fun onFailure(call: Call<AutocompleteCountry>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<AutocompleteCountry>,
                    response: Response<AutocompleteCountry>
                ) {
                    Log.d("country12",response.body().toString())
                    acCountryView.getCountryList(response.body())
                }
            })
    }
}