package com.mezet.actaandroid.presenters.promo

import android.util.Log
import com.mezet.actaandroid.fragments.main.promo.PromoFragment
import com.mezet.actaandroid.models.promo.PromoPayload
import com.mezet.actaandroid.models.promohomepage.PromoHome
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.PromoHomeView
import com.mezet.actaandroid.views.PromoView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PromoHomePresenter(context : PromoFragment){
    val promoView = context as PromoHomeView

    fun getPredstavljamo(){
        Log.d("radili","uraso je u poziv")
        RetrofitServices.create()
            .getPromo()
            .enqueue(object : Callback<PromoHome> {
                override fun onFailure(call: Call<PromoHome>, t: Throwable) {

                }

                override fun onResponse(call: Call<PromoHome>, response: Response<PromoHome>) {
                    promoView.getPromoRespones(response.body())
                }

            })
    }
}