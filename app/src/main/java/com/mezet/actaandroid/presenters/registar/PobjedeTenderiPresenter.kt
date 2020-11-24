package com.mezet.actaandroid.presenters.registar

import com.mezet.actaandroid.fragments.main.mojRegistar.sections.ObjavljeniTenderiFragment
import com.mezet.actaandroid.fragments.main.mojRegistar.sections.PobjedeNaTenderimaFragment
import com.mezet.actaandroid.models.pobjedenatenderima.TenderWinners
import com.mezet.actaandroid.models.publishedtenders.PublishedTenders
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.ObjavljeniTenderiView
import com.mezet.actaandroid.views.PobjedeTenderiView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PobjedeTenderiPresenter(context: PobjedeNaTenderimaFragment) {
    val objavljeniTenderiView = context as PobjedeTenderiView

    fun getTenderiPobjede(companyid:Int,page:Int,query:String,token:String) {
        RetrofitServices.create()
            .getWinners(companyid,page,query,token)
            .enqueue(object: Callback<TenderWinners> {
                override fun onFailure(call: Call<TenderWinners>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<TenderWinners>,
                    response: Response<TenderWinners>
                ) {
                    objavljeniTenderiView.getWinners(response.body())
                }
            })
    }
}