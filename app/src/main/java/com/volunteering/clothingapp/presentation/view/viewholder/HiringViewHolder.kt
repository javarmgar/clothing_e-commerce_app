package com.volunteering.clothingapp.presentation.view.viewholder

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.clothingapp.core.data.remote.model.HiringResponseModel
import com.volunteering.clothingapp.databinding.RvRowItemHiringBinding

class HiringViewHolder(
    private val binding: RvRowItemHiringBinding
) : RecyclerView.ViewHolder(
    binding.root
) {
    private val LOG_TAG:String = "LT_HiringViewHolder"

    fun bind(hiringItem: HiringResponseModel){
        Log.d(LOG_TAG, "bind() hiringItem $hiringItem")
        binding.apply {
            tvListIdValue.text = hiringItem.listId
            tvIdValue.text = hiringItem.id
            tvNameValue.text = hiringItem.name
        }
    }
}
