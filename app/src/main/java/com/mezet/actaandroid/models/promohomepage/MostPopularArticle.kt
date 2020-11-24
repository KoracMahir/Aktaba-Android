package com.mezet.actaandroid.models.promohomepage

data class MostPopularArticle(
    val ImgName: String,
    val PromoCategory: String,
    val PromoCategoryId: Int,
    val PromoId: Int,
    val Sections: List<SectionX>,
    val Title: String,
    val TitleUrl: String
)