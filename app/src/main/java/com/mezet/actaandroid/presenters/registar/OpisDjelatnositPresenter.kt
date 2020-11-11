package com.mezet.actaandroid.presenters.registar

import com.mezet.actaandroid.fragments.main.mojRegistar.sections.OpisDjelatnostiFragment
import com.mezet.actaandroid.fragments.main.mojRegistar.sections.UpravaRegistarFragment
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OpisDjelatnositPresenter(context: OpisDjelatnostiFragment) {
    val profilkompanijeview = context as CompanyByIdView

    fun getClientCompanyDj(companyid:Int,token:String) {
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
