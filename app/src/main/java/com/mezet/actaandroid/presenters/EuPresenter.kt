package com.mezet.actaandroid.presenters

import com.mezet.actaandroid.fragments.sections.AnalizeFragment
import com.mezet.actaandroid.fragments.sections.EuFragment
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.AnalizeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EuPresenter(context: EuFragment) {
    val vijestiView = context as AnalizeView

    fun getEUFromAPI() {
        RetrofitServices.create()
            .getEU()
            .enqueue(object : Callback<MostRecentNews> {
                override fun onFailure(call: Call<MostRecentNews>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<MostRecentNews>,
                    response: Response<MostRecentNews>
                ) {
                    vijestiView.onAnalize(response.body())
                }

            })
    }
}