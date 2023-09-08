package com.volunteering.clothingapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.clothingapp.core.data.remote.model.PaymentsModel
import com.volunteering.clothingapp.databinding.ItemPaymentMethodBinding
import com.volunteering.clothingapp.presentation.view.viewholder.PaymentMethodViewHolder

class NewPaymentMethodAdapter : ListAdapter<PaymentsModel, PaymentMethodViewHolder>(PaymentsDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PaymentMethodViewHolder {
        val binding = ItemPaymentMethodBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return PaymentMethodViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PaymentMethodViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item = item)
    }

    object PaymentsDiff : DiffUtil.ItemCallback<PaymentsModel>() {
        override fun areItemsTheSame(
            oldItem: PaymentsModel,
            newItem: PaymentsModel
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: PaymentsModel,
            newItem: PaymentsModel
        ): Boolean  = oldItem.bankNetwork == newItem.bankNetwork &&
                oldItem.textCardTypeNetwork == newItem.textCardTypeNetwork
    }
}
