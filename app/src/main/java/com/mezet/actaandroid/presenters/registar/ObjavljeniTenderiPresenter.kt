package com.mezet.actaandroid.presenters.registar

import com.mezet.actaandroid.fragments.main.mojRegistar.sections.DrugiKontaktiFragment
import com.mezet.actaandroid.fragments.main.mojRegistar.sections.ObjavljeniTenderiFragment
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.publishedtenders.PublishedTenders
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.ObjavljeniTenderiView
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ObjavljeniTenderiPresenter(context: ObjavljeniTenderiFragment) {
    val objavljeniTenderiView = context as ObjavljeniTenderiView

    fun getObjavljeniTenderi(companyid:Int,page:Int,query:String,token:String) {
        RetrofitServices.create()
            .getPublishedTenders(companyid,page,query,token)
            .enqueue(object:Callback<PublishedTenders>{
                override fun onFailure(call: Call<PublishedTenders>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<PublishedTenders>,
                    response: Response<PublishedTenders>
                ) {
                    objavljeniTenderiView.getObjavljeni(response.body())
                }
            })
    }
}