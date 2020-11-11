package com.mezet.actaandroid.models.company

data class CompanyPayload(
    val ACList: List<AC>,
    val ActiveTransactionalAccounts: List<ActiveTransactionalAccount>,
    val ActivityDescription: String,
    val Address: String,
    val BlockedTransactionalAccounts: List<Any>,
    val BlokiranoDanaIsVisible: Boolean,
    val BrojAktivnihRacuna: String,
    val BrojAktivnihRacunaIsVisible: Boolean,
    val BrojBlokadaIsVisible: Boolean,
    val BrojBlokiranihRacuna: String,
    val BrojBlokiranihRacunaIsVisible: Boolean,
    val BrojRadnikaIsVisible: Boolean,
    val BrojUgasenihRacuna: String,
    val BrojUgasenihRacunaIsVisible: Boolean,
    val City: String,
    val ClosedTransactionalAccounts: List<ClosedTransactionalAccount>,
    val CompanyAssortments: List<CompanyAssortment>,
    val CompanyPages: List<Any>,
    val Country: String,
    val Cpvs: String,
    val DateCreated: String,
    val DatumOtvaranjaIsVisible: Boolean,
    val DatumPosljednjeBlokadeIsVisible: Boolean,
    val Dobit: List<Dobit>,
    val Email: String,
    val Entitet: String,
    val Facebook: String,
    val Fax: String,
    val FullName: String,
    val GodinaIsVisible: Boolean,
    val Id: Int,
    val IdNumber: String,
    val Instagram: String,
    val IsBookMarked: Boolean,
    val IsLogged: Boolean,
    val IsPremium: Boolean,
    val IsRegistarContentVisible: Boolean,
    val IsTenderContentVisible: Boolean,
    val Kanton: String,
    val Kapital: Kapital,
    val LastYearFinance: LastYearFinance,
    val LinkedIn: String,
    val LogoFileId: Int,
    val LogoFileName: String,
    val LogoPath: String,
    val MainRns: List<MainRn>,
    val ManagerFullName: String,
    val ManagerHistory: List<Name>,
    val ManagerId: Int,
    val Mbs: String,
    val OtherContacts: String,
    val Owners: List<Owner>,
    val OwnershipType: String,
    val PdvNumber: String,
    val Phone: String,
    val Pinterest: String,
    val Povezana_Drustva: List<PovezanaDrustva>,
    val Regija: String,
    val ShortName: String,
    val StockIndex: String,
    val SveobuhvatnaDobitIsVisible: Boolean,
    val SviRacuniZatvoreniIsVisible: Boolean,
    val Twitter: String,
    val UkupanPrihodIsVisible: Boolean,
    val UkupanRashodIsVisible: Boolean,
    val Uprava: List<Uprava>,
    val VATNo: String,
    val Web: String,
    val YouTube: String,
    val ZipCode: String,
    val finansije: List<Finansije>,
    val paket: String
)