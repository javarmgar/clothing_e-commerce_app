package com.clothingapp.core.data.remote.model.params

import com.clothingapp.core.data.base.Model

data class ClothingCategory(
    val name:Category
): Model

enum class Category(val displayName: String) {
    TOPS("Tops"),
    BOTTOMS("Bottoms"),
    DRESSES_JUMPSUITS("Dresses & Jumpsuits"),
    OUTERWEAR("Outerwear"),
    ACTIVEWEAR("Activewear"),
    UNDERWEAR_LINGERIE("Underwear & Lingerie"),
    FOOTWEAR("Footwear"),
    ACCESSORIES("Accessories"),
    SWIMWEAR("Swimwear"),
    SPECIAL_OCCASIONS_ETHNIC("Special Occasions & Ethnic"),
    MATERNITY("Maternity"),
    KIDS_BABIES("Kids & Babies"),
    UNISEX("Unisex");
}
