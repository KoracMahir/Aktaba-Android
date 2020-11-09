package com.mezet.actaandroid.presenters.mojprofil

import com.mezet.actaandroid.fragments.main.mojProfil.ProfilIzdvojenoFragment
import com.mezet.actaandroid.fragments.main.mojProfil.subsections.PovezanaDrustvaFragment
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.izdvojeni.IzdvojenoPayload
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import com.mezet.actaandroid.views.mojprofil.IzdvojenoView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class IzdvojenoPresenter(context: ProfilIzdvojenoFragment) {
    val profilkompanijeview = context as IzdvojenoView

    fun getClientCompany(token:String) {
        RetrofitServices.create()
            .getIzdvojeno(token)
            .enqueue(object:Callback<IzdvojenoPayload>{
                override fun onFailure(call: Call<IzdvojenoPayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<IzdvojenoPayload>,
                    response: Response<IzdvojenoPayload>
                ) {
                    profilkompanijeview.getIzdvojeno(response.body())
                }
            })
    }
}