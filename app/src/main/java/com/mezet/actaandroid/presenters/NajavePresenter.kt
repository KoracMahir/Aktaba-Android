package com.mezet.actaandroid.presenters

import com.mezet.actaandroid.fragments.sections.AnalizeFragment
import com.mezet.actaandroid.fragments.sections.NajaveFragment
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.AnalizeView
import com.mezet.actaandroid.views.NajaveView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NajavePresenter(context: NajaveFragment) {
    val vijestiView = context as NajaveView

    fun getVijestiFromAPI() {
        RetrofitServices.create()
            .getNajave()
            .enqueue(object : Callback<MostRecentNews> {
                override fun onFailure(call: Call<MostRecentNews>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<MostRecentNews>,
                    response: Response<MostRecentNews>
                ) {
                    vijestiView.onNajave(response.body())
                }

            })
    }
}