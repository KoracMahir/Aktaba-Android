package com.mezet.actaandroid.models.promohomepage

data class SugestedArticle(
    val Description: String,
    val ImgName: String,
    val Priority: Int,
    val PromoCategory: String,
    val PromoCategoryId: Int,
    val PromoDate: String,
    val PromoId: Int,
    val Sections: List<SectionXXX>,
    val Title: String,
    val TitleUrl: String
)