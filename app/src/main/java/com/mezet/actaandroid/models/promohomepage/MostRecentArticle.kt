package com.mezet.actaandroid.models.promohomepage

data class MostRecentArticle(
    val ImgName: String,
    val PromoCategory: String,
    val PromoCategoryId: Int,
    val PromoId: Int,
    val Sections: List<SectionXX>,
    val Title: String,
    val TitleUrl: String
)