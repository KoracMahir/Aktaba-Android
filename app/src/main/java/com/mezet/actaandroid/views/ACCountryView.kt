package com.mezet.actaandroid.views

import com.mezet.actaandroid.models.autocompletecountry.AutocompleteCountry

interface ACCountryView {
    fun getCountryList(autocompleteCountry: AutocompleteCountry?)
}