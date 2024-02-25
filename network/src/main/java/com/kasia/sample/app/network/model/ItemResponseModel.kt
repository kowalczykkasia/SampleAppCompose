package com.kasia.sample.app.network.model

import com.google.gson.annotations.SerializedName
import com.kasia.sample.app.domain.models.Item

internal data class ItemResponseModel(
    @SerializedName("created_at") val createdAt: String,
    val height: Int,
    val id: String,
    @SerializedName("original_filename") val originalFilename: String,
    @SerializedName("sub_id") val subId: String?,
    val url: String,
    val width: Int
) {
    fun toItem() = Item(createdAt, height, id, originalFilename, subId, url, width)
}
