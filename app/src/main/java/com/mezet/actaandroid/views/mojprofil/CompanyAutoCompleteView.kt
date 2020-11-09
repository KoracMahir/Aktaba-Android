package com.mezet.actaandroid.views.mojprofil

import com.mezet.actaandroid.models.company.CompanyAutocompletePayload

interface CompanyAutoCompleteView {
    fun getCompanyNames(autocompletePayload: CompanyAutocompletePayload?)
    fun getCompanyIds(autocompletePayload: CompanyAutocompletePayload?)
}