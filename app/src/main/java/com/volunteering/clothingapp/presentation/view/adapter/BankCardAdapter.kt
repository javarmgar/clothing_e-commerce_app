package com.volunteering.clothingapp.presentation.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.clothingapp.core.data.base.BankCardModel
import com.volunteering.clothingapp.databinding.ItemCardBankBinding
import com.volunteering.clothingapp.presentation.view.viewholder.BankCardViewHolder

class BankCardAdapter : ListAdapter<BankCardModel, BankCardViewHolder>(BankCarDiff) {

    private val LOG_TAG:String = "LT_HiringAdapter"

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankCardViewHolder {
        val binding = ItemCardBankBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BankCardViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BankCardViewHolder, position: Int) {
        val item = getItem(position)
        Log.d(LOG_TAG, "bind() position:$position hiringItem $item")
        holder.bind(bankCardItem = item)
    }

    object BankCarDiff: DiffUtil.ItemCallback<BankCardModel>(){
        override fun areItemsTheSame(
            oldItem: BankCardModel,
            newItem: BankCardModel
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: BankCardModel,
            newItem: BankCardModel
        ): Boolean =
        oldItem.bankAccountNumber == newItem.bankAccountNumber &&
        oldItem.bankAccountName == newItem.bankAccountName &&
        oldItem.bankTypeNetwork == newItem.bankTypeNetwork &&
        oldItem.isCardSelected == newItem.isCardSelected

    }
}