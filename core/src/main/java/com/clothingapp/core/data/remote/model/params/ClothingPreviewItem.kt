package com.clothingapp.core.data.remote.model.params

import com.clothingapp.core.data.base.Model

data class ClothingPreviewItem(
    val itemId: String,
    val title: String,
    val images: List<String>,
    val distance: String,
    val price: String,
): Model
