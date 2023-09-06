package com.volunteering.clothingapp.presentation.view.viewholder

import android.app.Application
import androidx.recyclerview.widget.RecyclerView
import com.clothingapp.core.data.remote.model.BankNetwork
import com.clothingapp.core.data.remote.model.PaymentsModel
import com.volunteering.clothingapp.databinding.ItemPaymentMethodBinding

class PaymentMethodViewHolder(
    private val binding: ItemPaymentMethodBinding
): RecyclerView.ViewHolder(binding.root) {

    private val TAG = "LT_PayMthdViewHolder"

    fun bind(item: PaymentsModel){
        binding.apply {
            //TODO use glide to retrieve the image later
//            when(item.textCardTypeNetwork){
//                BankNetwork.APPLE_PAY ->
//            }
            tvCardBankTypeNetwork.text = item.textCardTypeNetwork
        }
    }

}