package com.mezet.actaandroid.models.mojprofil

data class TeritoriesIntersection(
    val Included: Boolean,
    val ParentTeritoryId: Int,
    val TerritoryId: Int,
    val TerritoryName: String
)