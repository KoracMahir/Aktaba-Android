package com.mezet.actaandroid.presenters.vijesti

import com.mezet.actaandroid.fragments.sections.AnalizeFragment
import com.mezet.actaandroid.fragments.sections.BihFragment
import com.mezet.actaandroid.models.Vijesti
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.AnalizeView
import com.mezet.actaandroid.views.MostRecentNewsView
import com.mezet.actaandroid.views.VijestiView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BiHPresenter(context: BihFragment) {
    val vijestiView = context as VijestiView

    fun getVijestiFromAPI() {
        RetrofitServices.create()
            .getBiH()
            .enqueue(object : Callback<MostRecentNews> {
                override fun onFailure(call: Call<MostRecentNews>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<MostRecentNews>,
                    response: Response<MostRecentNews>
                ) {
                    vijestiView.onVijesti(response.body())
                }

            })
    }
}