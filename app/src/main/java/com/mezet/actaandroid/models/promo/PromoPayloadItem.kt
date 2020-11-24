package com.mezet.actaandroid.models.promo

data class PromoPayloadItem(
    val Description: String,
    val ImgName: String,
    val Priority: Int,
    val PromoCategory: String,
    val PromoCategoryId: Int,
    val PromoDate: String,
    val PromoId: Int,
    val Sections: List<Section>,
    val Title: String,
    val TitleUrl: String
)