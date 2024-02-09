package com.kasia.sample.app.domain.models

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("created_at") val createdAt: String,
    val height: Int,
    val id: String,
    @SerializedName("original_filename") val originalFilename: String,
    @SerializedName("sub_id") val subId: String?,
    val url: String,
    val width: Int
)