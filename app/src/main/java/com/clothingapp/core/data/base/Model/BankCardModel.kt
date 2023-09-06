package com.clothingapp.core.data.base

data class BankCardModel(
    val bankAccountNumber: String,
    val bankAccountName: String,
    val bankTypeNetwork: BankNetwork,
    val isCardSelected: Boolean,
) : Model

enum class BankNetwork{
    MASTER_CARD,
    VISA,
}