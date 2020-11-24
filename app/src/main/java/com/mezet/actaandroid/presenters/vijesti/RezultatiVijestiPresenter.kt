package com.mezet.actaandroid.presenters.vijesti

import com.mezet.actaandroid.fragments.main.mojProfil.ProfilIzdvojenoFragment
import com.mezet.actaandroid.fragments.main.vijesti.search.VijestiRezultatiFragment
import com.mezet.actaandroid.models.Search
import com.mezet.actaandroid.models.izdvojeni.IzdvojenoPayload
import com.mezet.actaandroid.models.rezultativijesti.RezultatiVijesti
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.RezultatiVijestiView
import com.mezet.actaandroid.views.mojprofil.IzdvojenoView
import okhttp3.RequestBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RezultatiVijestiPresenter(context: VijestiRezultatiFragment) {
    val profilkompanijeview = context as RezultatiVijestiView

    fun getClientCompany(search:Search) {
        RetrofitServices.create()
            .getnewsSearch(search)
            .enqueue(object: Callback<RezultatiVijesti> {
                override fun onFailure(call: Call<RezultatiVijesti>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<RezultatiVijesti>,
                    response: Response<RezultatiVijesti>
                ) {
                    profilkompanijeview.getRezultati(response.body())
                }
            })
    }
}