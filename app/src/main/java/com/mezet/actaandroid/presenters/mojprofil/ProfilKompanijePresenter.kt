package com.mezet.actaandroid.presenters.mojprofil

import com.mezet.actaandroid.fragments.main.mojProfil.ProfilKompanijeFragment
import com.mezet.actaandroid.models.mojprofil.ClientProfile
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.mojprofil.ProfilKompanijeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilKompanijePresenter(context: ProfilKompanijeFragment) {
    val profilkompanijeview = context as ProfilKompanijeView

    fun getClientCompany(token:String) {
        RetrofitServices.create()
            .getClientProfile(token)
            .enqueue(object : Callback<ClientProfile> {
                override fun onFailure(call: Call<ClientProfile>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ClientProfile>,
                    response: Response<ClientProfile>
                ) {
                    profilkompanijeview.ClientCompanyData(response.body()?.ClientCompany)
                }


            })
    }
}