package com.mezet.actaandroid.models.promosearch.promosend

data class PromoSend(
    val CpvName: String,
    val Source: String,
    val Teritory: String,
    val country: String,
    val current_page: Int,
    val is_promo_search: Boolean,
    val publishdatefrom: String,
    val publishdateto: String,
    val search_cpv_code_id: Int,
    val search_source_Id: Int,
    val search_teritory_id: Int,
    val search_text: String,
    val section_id: Int,
    val selected_categories: String
)