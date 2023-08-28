package com.volunteering.clothingapp.framework.dataimpl.remote.model.response

import com.clothingapp.core.data.remote.base.ApiModel
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HiringResponse(
    @Json(name = "id")
    val id: String? = null,
    @Json(name = "listId")
    val listId: String? = null,
    @Json(name = "name")
    val name: String? = null,
): ApiModel