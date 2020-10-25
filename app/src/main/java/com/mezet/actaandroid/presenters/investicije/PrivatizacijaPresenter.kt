package com.mezet.actaandroid.presenters.investicije

import com.mezet.actaandroid.fragments.sections.BihFragment
import com.mezet.actaandroid.fragments.sections.PrivatizacijaFragment
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.VijestiView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PrivatizacijaPresenter(context: PrivatizacijaFragment) {
    val vijestiView = context as VijestiView

    fun getVijestiFromAPI() {
        RetrofitServices.create()
            .getPrivatizacija()
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