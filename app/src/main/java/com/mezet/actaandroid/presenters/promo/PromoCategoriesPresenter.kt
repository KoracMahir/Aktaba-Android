package com.mezet.actaandroid.presenters.promo

import android.util.Log
import com.mezet.actaandroid.fragments.main.promo.PromoFragment
import com.mezet.actaandroid.fragments.main.promo.PromoKategorijeFragment
import com.mezet.actaandroid.models.promohomepage.PromoHome
import com.mezet.actaandroid.models.promokategorije.PromoKategorije
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.PromoHomeView
import com.mezet.actaandroid.views.PromoKategorijeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PromoCategoriesPresenter(context : PromoKategorijeFragment){
    val promoView = context as PromoKategorijeView

    fun getKategorije(){
        Log.d("radili","uraso je u poziv")
        RetrofitServices.create()
            .getCategories()
            .enqueue(object:Callback<PromoKategorije>{
                override fun onFailure(call: Call<PromoKategorije>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<PromoKategorije>,
                    response: Response<PromoKategorije>
                ) {
                    promoView.getPromoRespones(response.body())
                }
            })
    }
}