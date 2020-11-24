package com.mezet.actaandroid.models.promohomepage

data class PromoHome(
    val CategoryArticles: List<CategoryArticle>,
    val MostPopularArticles: List<MostPopularArticle>,
    val MostRecentArticles: List<MostRecentArticle>,
    val SugestedArticles: List<SugestedArticle>
)