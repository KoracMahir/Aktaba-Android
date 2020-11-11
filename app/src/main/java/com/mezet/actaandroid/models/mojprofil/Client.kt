package com.mezet.actaandroid.models.mojprofil

data class Client(
    val ClientId: Int,
    val Comment: String,
    val Email: String,
    val FullName: String,
    val Gender: String,
    val Islogged: Boolean,
    val Newsletter: Boolean,
    val Paket: String,
    val Phone: String,
    val Position: String,
    val PremiumPackage: Boolean,
    val PremiumPlusPackage: Boolean,
    val PrimaryPackage: Boolean,
    val PromoPackage: Boolean,
    val ReceiveNewsletterPromo: Boolean,
    val ReceivesInformativeMails: Boolean,
    val ReceivesInformativeMailsNews: Boolean,
    val ReceivesInformativeMailsTrAccountChanges: Boolean,
    val ReceivesInformativeMailsWinners: Boolean,
    val ReceivesNewsletterNews: Boolean,
    val ReceivesNewsletterTenders: Boolean,
    val ReceivesNewsletterWinners: Boolean,
    val RegistarPackage: Boolean,
    val RegistarPlusPackage: Boolean,
    val Status: String,
    val TenderPackage: Boolean,
    val ValidTo: String
)