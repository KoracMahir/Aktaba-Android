package com.mezet.actaandroid.presenters.promo

import android.util.Log
import com.mezet.actaandroid.fragments.main.promo.PromoFragment
import com.mezet.actaandroid.models.promo.PromoPayload
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.PromoView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PromoPresenter (context : PromoFragment){
    val promoView = context as PromoView

    fun getPredstavljamo(categoryId:Int,limit:Int){
        Log.d("radili","uraso je u poziv")
        RetrofitServices.create()
            .getPromoCategorybyId(categoryId,limit)
            .enqueue(object : Callback<PromoPayload> {
                override fun onFailure(call: Call<PromoPayload>, t: Throwable) {

                }

                override fun onResponse(call: Call<PromoPayload>, response: Response<PromoPayload>) {
                    promoView.getPromoRespones(response.body())
                }

            })
    }
}