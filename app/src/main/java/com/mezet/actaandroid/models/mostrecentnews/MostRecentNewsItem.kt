package com.mezet.actaandroid.models.mostrecentnews

data class MostRecentNewsItem(
    val category_id: Int,
    val category_name: String,
    val news_date: String,
    val news_id: Int,
    val news_image: String,
    val news_name: String,
    val news_url: String,
    val priority: Int,
    val section_id: Int,
    val section_name: String,
    val sections: List<Section>
)