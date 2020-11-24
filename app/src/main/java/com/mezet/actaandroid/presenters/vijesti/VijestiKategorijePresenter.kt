package com.mezet.actaandroid.presenters.vijesti

import android.util.Log
import com.mezet.actaandroid.fragments.main.vijesti.search.SearchKategorijeFragment
import com.mezet.actaandroid.fragments.main.vijesti.search.SearchKategorijePrivredeFragment
import com.mezet.actaandroid.models.privreda.PrivredaKategorije
import com.mezet.actaandroid.models.vijestikategorije.VijestiKategorije
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.PrivredaView
import com.mezet.actaandroid.views.VijestiKategorijeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VijestiKategorijePresenter (context : SearchKategorijeFragment){
    val promoView = context as VijestiKategorijeView

    fun getKategorije(){
        Log.d("radili","uraso je u poziv")
        RetrofitServices.create()
            .getVijestiCategories()
            .enqueue(object: Callback<VijestiKategorije> {
                override fun onFailure(call: Call<VijestiKategorije>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<VijestiKategorije>,
                    response: Response<VijestiKategorije>
                ) {
                    promoView.getKategorije(response.body())
                }
            })
    }
}