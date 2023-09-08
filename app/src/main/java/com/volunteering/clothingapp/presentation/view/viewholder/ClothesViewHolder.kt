package com.volunteering.clothingapp.presentation.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.clothingapp.core.data.remote.model.params.ClothingPreviewItem
import com.volunteering.clothingapp.databinding.ItemCardClothBinding

class ClothesViewHolder(
    private val binding: ItemCardClothBinding
): RecyclerView.ViewHolder(binding.root) {

    private val TAG = "LT_CategoryViewHolder"

    fun bind(item: ClothingPreviewItem, onClickDetail: (ClothingPreviewItem) -> Unit){
        binding.apply {
            //TODO use glide to retrieve the image later to fillivClotheCategory.setImageResource(...)
            tvClotheTitle.text = item.title
            tvClothePrice.text = item.price
            layoutItemDistance.tvClotheLocationDistance.text = item.distance
            root.setOnClickListener { onClickDetail(item) }
        }
    }

}