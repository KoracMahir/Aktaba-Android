package com.mezet.actaandroid.models.izdvojeni

data class TenderX(
    val IsWinner: Boolean,
    val tender_datum: String,
    val tender_id: Int,
    val tender_isPublicAll: Boolean,
    val tender_name: String,
    val tender_requester: TenderRequester,
    val tender_validto: String
)