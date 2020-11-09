package com.mezet.actaandroid.presenters.mojprofil

import com.mezet.actaandroid.fragments.main.mojProfil.ProfilKompanijeFragment
import com.mezet.actaandroid.fragments.main.mojProfil.subsections.PovezanaDrustvaFragment
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.company.PovezanaDrustva
import com.mezet.actaandroid.models.mojprofil.ClientProfile
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import com.mezet.actaandroid.views.mojprofil.ProfilKompanijeView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CompanyByIdPresenter(context: PovezanaDrustvaFragment) {
    val profilkompanijeview = context as CompanyByIdView

    fun getClientCompany(companyid:Int,token:String) {
        RetrofitServices.create()
            .getCompanyData(companyid,token)
            .enqueue(object : Callback<CompanyPayload> {
                override fun onFailure(call: Call<CompanyPayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<CompanyPayload>,
                    response: Response<CompanyPayload>
                ) {
                    profilkompanijeview.getCompany(response.body())
                }


            })
    }
}