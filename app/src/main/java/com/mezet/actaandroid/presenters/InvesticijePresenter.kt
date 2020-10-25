package com.mezet.actaandroid.presenters

import android.util.Log
import com.mezet.actaandroid.fragments.sections.NewsBlueBlackFragment
import com.mezet.actaandroid.fragments.sections.OnePlusTwoFragment
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.InvesticijeView
import com.mezet.actaandroid.views.VijestiView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class InvesticijePresenter(context: NewsBlueBlackFragment) {
    val vijestiView = context as InvesticijeView

    fun getVijestiFromAPI() {
        RetrofitServices.create()
            .getInvesticije()
            .enqueue(object : Callback<MostRecentNews> {
                override fun onFailure(call: Call<MostRecentNews>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<MostRecentNews>,
                    response: Response<MostRecentNews>
                ) {
                    vijestiView.onInvesticije(response.body())
                }

            })
    }
}