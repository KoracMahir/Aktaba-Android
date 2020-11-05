package com.mezet.actaandroid.presenters

import com.mezet.actaandroid.fragments.sections.AnalizeFragment
import com.mezet.actaandroid.fragments.sections.NewsBlueBlackFragment
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.AnalizeView
import com.mezet.actaandroid.views.InvesticijeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AnalizePresenter(context: AnalizeFragment) {
    val vijestiView = context as AnalizeView

    fun getVijestiFromAPI() {
        RetrofitServices.create()
            .getAnalize()
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