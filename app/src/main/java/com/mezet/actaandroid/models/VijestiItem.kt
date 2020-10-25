package com.mezet.actaandroid.models

data class VijestiItem(
    val IsLogged: Boolean,
    val bookmarked: Boolean,
    val category_id: Int,
    val category_name: String,
    val isPublicForWebSite: Boolean,
    val isSponsored: Boolean,
    val news_date: String,
    val news_description: String,
    val news_id: Int,
    val news_image: String,
    val news_name: String,
    val news_source: String,
    val news_url: String,
    val priority: Int,
    val section_id: Int,
    val section_name: String
)