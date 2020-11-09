package com.mezet.actaandroid.models.kojepratim

data class KojePratimPayloadItem(
    val ClientCompanyFavoriteId: Int,
    val ClientId: Int,
    val CompanyId: Int,
    val CompanyName: String,
    val InfoMailNews: Boolean,
    val InfoMailTenders: Boolean,
    val InfoMailTrAccountChanges: Boolean,
    val InfoMailWinners: Boolean
)