package com.mezet.actaandroid.models.ucescenatenderima

data class UcesceNaTenderimaItem(
    val IsWinner: Boolean,
    val tender_datum: String,
    val tender_id: Int,
    val tender_isPublicAll: Boolean,
    val tender_name: String,
    val tender_number: String,
    val tender_requester: TenderRequester,
    val tender_url: String,
    val tender_validto: String,
    val tender_value: String
)