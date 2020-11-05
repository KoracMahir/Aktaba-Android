package com.mezet.actaandroid.models

data class LoginResponse(
    val ClientCompanyName: String,
    val Paket: String,
    val UserEmail: String,
    val UserId: Int,
    val token: String
)