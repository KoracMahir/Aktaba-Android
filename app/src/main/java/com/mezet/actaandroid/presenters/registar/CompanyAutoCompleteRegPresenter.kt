package com.mezet.actaandroid.presenters.registar

import com.mezet.actaandroid.fragments.main.mojProfil.ProfilPracenjeFragment
import com.mezet.actaandroid.fragments.main.mojRegistar.registarPretraga.RegistarPretragaFragment
import com.mezet.actaandroid.models.company.CompanyAutocompletePayload
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.mojprofil.CompanyAutoCompleteView
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompanyAutoCompleteRegPresenter(context: RegistarPretragaFragment?) {
    val profilkompanijeview = context as CompanyAutoCompleteView

    fun getClientCompanyName(term:String) {
        RetrofitServices.create()
            .getCompanyAutoComplete(term)
            .enqueue(object : Callback<CompanyAutocompletePayload> {
                override fun onFailure(call: Call<CompanyAutocompletePayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CompanyAutocompletePayload>,
                    response: Response<CompanyAutocompletePayload>
                ) {
                    profilkompanijeview.getCompanyNames(response.body())
                }
            })
    }
    fun getClientCompanyId(term:String) {
        RetrofitServices.create()
            .getCompanyIDAutoComplete(term)
            .enqueue(object : Callback<CompanyAutocompletePayload> {
                override fun onFailure(call: Call<CompanyAutocompletePayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CompanyAutocompletePayload>,
                    response: Response<CompanyAutocompletePayload>
                ) {
                    profilkompanijeview.getCompanyIds(response.body())
                }
            })
    }
}