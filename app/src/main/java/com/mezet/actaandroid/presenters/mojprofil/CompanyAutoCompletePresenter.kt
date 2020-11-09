package com.mezet.actaandroid.presenters.mojprofil

import android.content.Context
import com.mezet.actaandroid.fragments.main.mojProfil.ProfilPracenjeFragment
import com.mezet.actaandroid.fragments.main.mojProfil.subsections.PovezanaDrustvaFragment
import com.mezet.actaandroid.models.company.CompanyAutocompletePayload
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.mojprofil.ClientProfile
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.mojprofil.CompanyAutoCompleteView
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import com.mezet.actaandroid.views.mojprofil.ProfilKompanijeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompanyAutoCompletePresenter(context: ProfilPracenjeFragment?) {
    val profilkompanijeview = context as CompanyAutoCompleteView
    val profilkompanijeview2 = context as CompanyByIdView

    fun getClientCompany(term:String) {
        RetrofitServices.create()
            .getCompanyAutoComplete(term)
            .enqueue(object : Callback<CompanyAutocompletePayload>{
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
            .enqueue(object : Callback<CompanyAutocompletePayload>{
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
    fun getCompany(companyid:Int,token:String) {
        RetrofitServices.create()
            .getCompanyData(companyid,token)
            .enqueue(object : Callback<CompanyPayload> {
                override fun onFailure(call: Call<CompanyPayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CompanyPayload>,
                    response: Response<CompanyPayload>
                ) {
                    profilkompanijeview2.getCompany(response.body())
                }


            })
    }
}