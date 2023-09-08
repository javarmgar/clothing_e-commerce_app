package com.volunteering.clothingapp.presentation.view.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.clothingapp.core.data.remote.model.params.ClothingCategory
import com.volunteering.clothingapp.databinding.ItemCardCategoryBinding

class CategoryViewHolder(
    private val binding: ItemCardCategoryBinding
): RecyclerView.ViewHolder(binding.root) {

    private val TAG = "LT_CategoryViewHolder"

    fun bind(item: ClothingCategory){
        binding.apply {
            //TODO use glide to retrieve the image later to fillivClotheCategory.setImageResource(...)
            tvClotheCategoryTitle.text = item.name.toString()
        }
    }

}