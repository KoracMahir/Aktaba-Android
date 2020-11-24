package com.mezet.actaandroid.presenters.vijesti

import com.mezet.actaandroid.fragments.main.home.BerzaFragment
import com.mezet.actaandroid.fragments.main.home.KursnaListaFragment
import com.mezet.actaandroid.models.berza.Berza
import com.mezet.actaandroid.models.kursnalista.KursnaLista
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.BerzaView
import com.mezet.actaandroid.views.KursnaListaView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class KursnaListaPresenter (context: KursnaListaFragment) {
    val kursView = context as KursnaListaView

    fun getClientCompany() {
        RetrofitServices.create()
            .getKursnaLista()
            .enqueue(object : Callback<KursnaLista>{
                override fun onFailure(call: Call<KursnaLista>, t: Throwable) {

                }

                override fun onResponse(call: Call<KursnaLista>, response: Response<KursnaLista>) {
                    kursView.getKursnaLista(response.body())
                }
            })
    }
}