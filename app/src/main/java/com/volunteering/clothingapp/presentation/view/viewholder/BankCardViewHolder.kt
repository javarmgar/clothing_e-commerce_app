package com.volunteering.clothingapp.presentation.view.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.clothingapp.core.data.remote.model.BankCardModel
import com.clothingapp.core.data.remote.model.BankNetwork
import com.volunteering.clothingapp.R
import com.volunteering.clothingapp.databinding.ItemCardBankBinding

class BankCardViewHolder(
    private val binding: ItemCardBankBinding
) : RecyclerView.ViewHolder(
    binding.root
) {
    private val LOG_TAG:String = "LT_BankCardViewHolder"

    fun bind(bankCardItem: BankCardModel){
        Log.d(LOG_TAG, "bind() hiringItem $bankCardItem")
        binding.apply {
            tvBankAccountNumber.text = bankCardItem.bankAccountNumber
            tvBankAccountName.text = bankCardItem.bankAccountName
            when(bankCardItem.bankTypeNetwork){
                BankNetwork.MASTER_CARD -> ivCardBankTypeNetwork.setImageResource(R.drawable.ic_visa_vector)
                else -> ivCardBankTypeNetwork.setImageResource(R.drawable.ic_visa_vector)
            }
            cbCardSelected.isChecked = bankCardItem.isCardSelected

        }
    }

}
