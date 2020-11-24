package com.mezet.actaandroid.presenters.vijesti

import com.mezet.actaandroid.fragments.main.vijesti.JedinstvenaVijestFragment
import com.mezet.actaandroid.fragments.main.vijesti.search.VijestiRezultatiFragment
import com.mezet.actaandroid.models.Search
import com.mezet.actaandroid.models.jedinstvenavijesti.JedinstvenaVijest
import com.mezet.actaandroid.models.rezultativijesti.RezultatiVijesti
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.JedinstvenaVijestView
import com.mezet.actaandroid.views.RezultatiVijestiView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class JedinstvenaVijestPresenter(context: JedinstvenaVijestFragment) {
    val profilkompanijeview = context as JedinstvenaVijestView

    fun getJedinstvenaVijesti(articleId:Int) {
        RetrofitServices.create()
            .getUniqeNew(articleId)
            .enqueue(object: Callback<JedinstvenaVijest> {
                override fun onFailure(call: Call<JedinstvenaVijest>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<JedinstvenaVijest>,
                    response: Response<JedinstvenaVijest>
                ) {
                    profilkompanijeview.getJedinstvenaVijesti(response.body())
                }
            })
    }
}