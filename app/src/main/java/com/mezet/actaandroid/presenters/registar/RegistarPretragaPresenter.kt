package com.mezet.actaandroid.presenters.registar

import com.mezet.actaandroid.activities.RegistarRezultatiActivity
import com.mezet.actaandroid.fragments.main.Registar
import com.mezet.actaandroid.fragments.main.mojRegistar.sections.FinansijeRegistarFragment
import com.mezet.actaandroid.models.company.CompanyPayload
import com.mezet.actaandroid.models.registarsearch.RegistarPayload
import com.mezet.actaandroid.services.RetrofitServices
import com.mezet.actaandroid.views.RegistarPretragaView
import com.mezet.actaandroid.views.mojprofil.CompanyByIdView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RegistarPretragaPresenter(context: RegistarRezultatiActivity) {
    val registarPretragaView = context as RegistarPretragaView

    fun getClientCompanyFin(registar : com.mezet.actaandroid.models.registarsearch.Registar) {
        RetrofitServices.create()
            .getSearchRegisterNew(registar)
            .enqueue(object : Callback<RegistarPayload>{
                override fun onFailure(call: Call<RegistarPayload>, t: Throwable) {

                }

                override fun onResponse(
                    call: Call<RegistarPayload>,
                    response: Response<RegistarPayload>
                ) {
                    registarPretragaView.getCompaniesData(response.body())
                }
            })
    }
}