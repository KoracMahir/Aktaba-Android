package com.mezet.actaandroid.views.mojprofil

import com.mezet.actaandroid.models.company.CompanyPayload

interface CompanyByIdView {
    fun getCompany(companyPayload: CompanyPayload?)
}