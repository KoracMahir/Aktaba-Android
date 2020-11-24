package com.mezet.actaandroid.presenters.vijesti

import com.mezet.actaandroid.fragments.main.home.BerzaFragment
import com.mezet.actaandroid.models.berza.Berza
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.BerzaView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BerzaPresenter (context: BerzaFragment) {
    val berzaView = context as BerzaView

    fun getClientCompany() {
        RetrofitServices.create()
            .getStock()
            .enqueue(object:Callback<Berza>{
                override fun onFailure(call: Call<Berza>, t: Throwable) {

                }

                override fun onResponse(call: Call<Berza>, response: Response<Berza>) {
                    berzaView.getBerza(response.body())
                }
            })
    }
}