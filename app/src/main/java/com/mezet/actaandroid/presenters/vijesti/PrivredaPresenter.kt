package com.mezet.actaandroid.presenters.vijesti

import android.util.Log
import com.mezet.actaandroid.fragments.main.promo.PromoKategorijeFragment
import com.mezet.actaandroid.fragments.main.vijesti.search.SearchKategorijePrivredeFragment
import com.mezet.actaandroid.models.privreda.PrivredaKategorije
import com.mezet.actaandroid.models.promokategorije.PromoKategorije
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.PrivredaView
import com.mezet.actaandroid.views.PromoKategorijeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PrivredaPresenter(context : SearchKategorijePrivredeFragment){
    val promoView = context as PrivredaView

    fun getKategorije(){
        Log.d("radili","uraso je u poziv")
        RetrofitServices.create()
            .getPrivredaCategories()
            .enqueue(object: Callback<PrivredaKategorije> {
                override fun onFailure(call: Call<PrivredaKategorije>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<PrivredaKategorije>,
                    response: Response<PrivredaKategorije>
                ) {
                    promoView.getPrivredaCategories(response.body())
                }
            })
    }
}