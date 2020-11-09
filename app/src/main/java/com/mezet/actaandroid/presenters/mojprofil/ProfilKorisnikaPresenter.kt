package com.mezet.actaandroid.presenters.mojprofil

import com.mezet.actaandroid.fragments.main.mojProfil.ProfilKorisnikaFragment
import com.mezet.actaandroid.fragments.sections.EuFragment
import com.mezet.actaandroid.models.mojprofil.ClientProfile
import com.mezet.actaandroid.models.mostrecentnews.MostRecentNews
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.AnalizeView
import com.mezet.actaandroid.views.mojprofil.ProfilKorisnikaView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProfilKorisnikaPresenter(context: ProfilKorisnikaFragment) {
    val profilKorisnikaView = context as ProfilKorisnikaView

    fun getClientName(token:String) {
        RetrofitServices.create()
            .getClientProfile(token)
            .enqueue(object : Callback<ClientProfile> {
                override fun onFailure(call: Call<ClientProfile>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ClientProfile>,
                    response: Response<ClientProfile>
                ) {
                    profilKorisnikaView.getClient(response.body()?.Client)
                }


            })
    }
    fun getClientFax(token:String) {
        RetrofitServices.create()
            .getClientProfile(token)
            .enqueue(object : Callback<ClientProfile> {
                override fun onFailure(call: Call<ClientProfile>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ClientProfile>,
                    response: Response<ClientProfile>
                ) {
                    profilKorisnikaView.getClientFax(response.body()?.ClientCompany?.Phone.toString())
                }


            })
    }
    fun getCompanyId(token:String) {
        RetrofitServices.create()
            .getClientProfile(token)
            .enqueue(object : Callback<ClientProfile> {
                override fun onFailure(call: Call<ClientProfile>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<ClientProfile>,
                    response: Response<ClientProfile>
                ) {
                    response?.body()?.ClientCompany?.Id?.let { profilKorisnikaView.getCompanyId(it) }
                }


            })
    }
}