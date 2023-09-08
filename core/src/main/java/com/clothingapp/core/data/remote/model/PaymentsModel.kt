package com.clothingapp.core.data.remote.model

import com.clothingapp.core.data.base.Model

class PaymentsModel(
    val bankNetwork: BankNetwork,
    val urlImageCardTypeNetwork: String,
    val textCardTypeNetwork: String
):Model
