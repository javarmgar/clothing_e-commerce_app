package com.volunteering.clothingapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.clothingapp.core.data.remote.model.params.ClothingCategory
import com.volunteering.clothingapp.databinding.ItemCardCategoryBinding
import com.volunteering.clothingapp.presentation.view.viewholder.CategoryViewHolder

class CategoryAdapter : ListAdapter<ClothingCategory, CategoryViewHolder>(CategoryDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding = ItemCardCategoryBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return CategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item = item)
    }

    object CategoryDiff : DiffUtil.ItemCallback<ClothingCategory>() {
        override fun areItemsTheSame(
            oldItem: ClothingCategory,
            newItem: ClothingCategory
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: ClothingCategory,
            newItem: ClothingCategory
        ): Boolean  = oldItem.name == newItem.name
    }
}
