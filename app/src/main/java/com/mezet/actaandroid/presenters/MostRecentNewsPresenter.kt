package com.mezet.actaandroid.presenters

import android.util.Log
import com.mezet.actaandroid.fragments.HomeFragment
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.MostRecentNewsView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MostRecentNewsPresenter(context: HomeFragment){
    val vijestiView = context as MostRecentNewsView

    fun getMostRecentFromAPI(){
        Log.d("radili","uraso je u poziv")
        RetrofitServices.create()
            .getMostRecentNews()
            .enqueue(object : Callback<MostRecentNews>{
                override fun onFailure(call: Call<MostRecentNews>, t: Throwable) {
                    vijestiView.onFailiuer(t.toString())
                }

                override fun onResponse(call: Call<MostRecentNews>, response: Response<MostRecentNews>) {
                    vijestiView.onMostRecentNews(response.body())
                }

            })
    }
}