package com.mezet.actaandroid.models.mojprofil

data class ClientProfile(
    val Client: Client,
    val ClientCompany: ClientCompany,
    val CpvIdustriesIntersection: List<CpvIdustriesIntersection>,
    val TeritoriesIntersection: List<TeritoriesIntersection>
)