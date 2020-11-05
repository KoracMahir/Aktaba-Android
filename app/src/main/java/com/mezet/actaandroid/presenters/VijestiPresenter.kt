package com.mezet.actaandroid.presenters

import android.util.Log
import com.mezet.actaandroid.fragments.sections.OnePlusTwoFragment
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.VijestiView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class VijestiPresenter(context: OnePlusTwoFragment){
    val vijestiView = context as VijestiView

    fun getVijestiFromAPI(){
        Log.d("radili","uraso je u poziv")
        RetrofitServices.create()
            .getVijesti()
            .enqueue(object : Callback<MostRecentNews>{
                override fun onFailure(call: Call<MostRecentNews>, t: Throwable) {
                    vijestiView.onVijestiFailiuer(t.toString())
                }

                override fun onResponse(call: Call<MostRecentNews>, response: Response<MostRecentNews>) {
                    vijestiView.onVijesti(response.body())
                }

            })
    }
}