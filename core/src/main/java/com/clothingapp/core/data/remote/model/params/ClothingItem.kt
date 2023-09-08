package com.clothingapp.core.data.remote.model.params

data class ClothingItem(
    val itemId: String,
    val title: String,
    val description: String,
    val images: List<String>,
    val category: Category,
    val subcategory: String,
    val condition: Condition,
    val size: Size,
    val price: Price,
    val brand: String,
    val material: String,
    val careInstructions: String,
    val color: Color,
    val location: Location,
    val shippingOptions: List<ShippingOption>,
    val seller: Seller,
    val season: Season,
    val occasion: Occasion,
    val dateListed: String,
    val popularity: Int,
    val status: Status
)


enum class Condition {
    BRAND_NEW, LIKE_NEW, GOOD, FAIR, WELL_WORN
}

enum class Size{
    XS,
    S,
    M,
    L,
    XL,
    XXL,
}

data class Measurements(
    val chest: String,
    val length: String
    // Add other measurements as needed
)

data class Price(
    val original: Double,
    val selling: Double
)

data class Color(
    val primary: String,
    val pattern: String
)

data class Location(
    val city: String,
    val state: String,
    val country: String,
    val geo: Geo
)

fun Location.oneLine(): String {
    return "$city $state $country"
}

data class Geo(
    val latitude: Double,
    val longitude: Double
)

enum class ShippingOption {
    FREE_SHIPPING, EXPRESS_DELIVERY, STANDARD_SHIPPING, LOCAL_PICKUP
}

data class Seller(
    val sellerId: String,
    val rating: Double,
    val name: String,
)

enum class Season {
    SPRING, SUMMER, AUTUMN, WINTER, ALL_SEASON
}

enum class Occasion {
    CASUAL, FORMAL, ATHLETIC, BUSINESS, NIGHT_OUT, FESTIVE
}

enum class Status(val param1:String) {
    AVAILABLE("AVAILABLE"),
    SOLD("SOLD"),
    RESERVED("INACTIVE"),
    ARCHIVED("INACTIVE"),
}
