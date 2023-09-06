package com.clothingapp.core.data.remote.model

import com.clothingapp.core.data.base.Model

data class BankCardModel(
    val bankAccountNumber: String,
    val bankAccountName: String,
    val bankTypeNetwork: BankNetwork,
    val isCardSelected: Boolean,
) : Model

enum class BankNetwork{
    MASTER_CARD,
    VISA,
    APPLE_PAY,
}