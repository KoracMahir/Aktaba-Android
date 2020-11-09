package com.mezet.actaandroid.models.company

data class ClosedTransactionalAccount(
    val AccountActivationDate: String,
    val AccountClosingDate: String,
    val AccountOpeningDate: String,
    val AccountStatusChangeDate: String,
    val AccountType: String,
    val NameOfBank: String,
    val NameOfBankUrl: String,
    val TransactionalAccountNumber: String
)