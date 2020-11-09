package com.mezet.actaandroid.models.izdvojeni

data class PromoX(
    val IsWinner: Boolean,
    val promo_datum: String,
    val promo_id: Int,
    val promo_isPublicAll: Boolean,
    val promo_name: String,
    val promo_requester: PromoRequester,
    val promo_validto: String
)