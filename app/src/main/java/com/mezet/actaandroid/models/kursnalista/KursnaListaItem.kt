package com.mezet.actaandroid.models.kursnalista

data class KursnaListaItem(
    val Jedinica: Int,
    val KupovniKurs: Double,
    val KursnaListaDatum: String,
    val OznakaValute: String,
    val ProdajniKurs: Double,
    val SifraValute: String,
    val SrednjiKurs: Double,
    val Zemlja: String
)