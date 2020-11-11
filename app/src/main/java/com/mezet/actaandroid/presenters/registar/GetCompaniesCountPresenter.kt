package com.mezet.actaandroid.presenters.registar

import com.mezet.actaandroid.fragments.main.mojRegistar.registarPretraga.RegistarPretragaFragment
import com.mezet.actaandroid.fragments.sections.AnalizeFragment
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.AnalizeView
import com.mezet.actaandroid.views.GetCompaniesCountView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class GetCompaniesCountPresenter(context: RegistarPretragaFragment) {
    val vijestiView = context as GetCompaniesCountView

    fun getVijestiFromAPI() {
        RetrofitServices.create()
            .getCompaniesCount()
            .enqueue(object : Callback<Int>{
                override fun onFailure(call: Call<Int>, t: Throwable) {

                }

                override fun onResponse(call: Call<Int>, response: Response<Int>) {
                    vijestiView.getCompaniesCount(response.body())
                }
            })
    }
}