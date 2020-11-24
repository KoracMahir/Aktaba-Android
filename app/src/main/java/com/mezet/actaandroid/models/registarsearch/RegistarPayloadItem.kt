package com.mezet.actaandroid.models.registarsearch

data class RegistarPayloadItem(
    val Address: String,
    val City: String,
    val FullName: String,
    val Id: Int,
    val IsBookMarked: Boolean,
    val ShortName: String,
    val ZipCode: String
)