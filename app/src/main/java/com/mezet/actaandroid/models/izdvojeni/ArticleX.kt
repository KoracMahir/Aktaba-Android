package com.mezet.actaandroid.models.izdvojeni

data class ArticleX(
    val IsWinner: Boolean,
    val article_datum: String,
    val article_id: Int,
    val article_isPublicAll: Boolean,
    val article_name: String,
    val article_requester: ArticleRequester,
    val article_validto: String
)