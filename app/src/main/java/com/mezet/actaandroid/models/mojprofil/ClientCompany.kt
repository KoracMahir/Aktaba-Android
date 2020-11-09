package com.mezet.actaandroid.models.mojprofil

data class ClientCompany(
    val ACList: List<AC>,
    val ActivityDescription: String,
    val Address: String,
    val BlokiranoDanaIsVisible: Boolean,
    val BrojAktivnihRacuna: String,
    val BrojAktivnihRacunaIsVisible: Boolean,
    val BrojBlokadaIsVisible: Boolean,
    val BrojBlokiranihRacuna: String,
    val BrojBlokiranihRacunaIsVisible: Boolean,
    val BrojRadnikaIsVisible: Boolean,
    val BrojUgasenihRacunaIsVisible: Boolean,
    val City: String,
    val DateCreated: String,
    val DatumOtvaranjaIsVisible: Boolean,
    val DatumPosljednjeBlokadeIsVisible: Boolean,
    val Email: String,
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
    val LastYearFinance: LastYearFinance,
    val LinkedIn: String,
    val LogoFileId: Int,
    val LogoFileName: String,
    val LogoPath: String,
    val ManagerFullName: String,
    val ManagerId: Int,
    val OtherContacts: String,
    val OwnershipType: String,
    val PdvNumber: String,
    val Phone: String,
    val Pinterest: String,
    val ShortName: String,
    val StockIndex: String,
    val SveobuhvatnaDobitIsVisible: Boolean,
    val SviRacuniZatvoreniIsVisible: Boolean,
    val Twitter: String,
    val UkupanPrihodIsVisible: Boolean,
    val UkupanRashodIsVisible: Boolean,
    val VATNo: String,
    val Web: String,
    val YouTube: String,
    val ZipCode: String,
    val finansije: List<Finansije>
)