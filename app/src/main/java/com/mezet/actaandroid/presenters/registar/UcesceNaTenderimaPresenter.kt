package com.mezet.actaandroid.presenters.registar

import com.mezet.actaandroid.fragments.main.mojRegistar.sections.PobjedeNaTenderimaFragment
import com.mezet.actaandroid.fragments.main.mojRegistar.sections.UcesceNaTenderimaFragment
import com.mezet.actaandroid.models.pobjedenatenderima.TenderWinners
import com.mezet.actaandroid.models.ucescenatenderima.UcesceNaTenderima
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.PobjedeTenderiView
import com.mezet.actaandroid.views.UcesceNaTenderimaView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UcesceNaTenderimaPresenter(context: UcesceNaTenderimaFragment) {
    val ucesceNaTenderimaView = context as UcesceNaTenderimaView

    fun getUcesceTenderi(companyid:Int,page:Int,query:String,token:String) {
        RetrofitServices.create()
            .getParticipation(companyid,page,query,token)
            .enqueue(object: Callback<UcesceNaTenderima> {
                override fun onFailure(call: Call<UcesceNaTenderima>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<UcesceNaTenderima>,
                    response: Response<UcesceNaTenderima>
                ) {
                    ucesceNaTenderimaView.getUcesce(response.body())
                }
            })
    }
}