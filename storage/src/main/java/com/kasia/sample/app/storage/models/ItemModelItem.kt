package com.kasia.sample.app.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "photos_table")
data class Item(
    @SerializedName("created_at") val createdAt: String,
    val height: Int,
    @PrimaryKey val id: String,
    @SerializedName("original_filename") val originalFilename: String,
    @SerializedName("sub_id") val subId: String?,
    val url: String,
    val width: Int
) {
    constructor() : this("", 0, "", "", "", "", 0)
}