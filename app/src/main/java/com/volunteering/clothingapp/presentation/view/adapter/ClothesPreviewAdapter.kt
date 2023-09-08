package com.volunteering.clothingapp.presentation.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.clothingapp.core.data.remote.model.params.ClothingPreviewItem
import com.volunteering.clothingapp.databinding.ItemCardClothBinding
import com.volunteering.clothingapp.presentation.view.viewholder.ClothesViewHolder

class ClothesPreviewAdapter(private val onClickDetail: (ClothingPreviewItem) -> Unit) : ListAdapter<ClothingPreviewItem, ClothesViewHolder>(ClothingPreviewDiff) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClothesViewHolder {
        val binding = ItemCardClothBinding.inflate(LayoutInflater.from(parent.context),parent, false)

        return ClothesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ClothesViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item = item, onClickDetail)
    }

    object ClothingPreviewDiff : DiffUtil.ItemCallback<ClothingPreviewItem>() {
        override fun areItemsTheSame(
            oldItem: ClothingPreviewItem,
            newItem: ClothingPreviewItem
        ): Boolean = oldItem == newItem

        override fun areContentsTheSame(
            oldItem: ClothingPreviewItem,
            newItem: ClothingPreviewItem
        ): Boolean  =
            oldItem.itemId == newItem.itemId &&
            oldItem.distance == newItem.distance &&
            oldItem.price == newItem.price &&
            oldItem.title == newItem.title
    }
}
