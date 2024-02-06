package com.kasia.sample.app.storage.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kasia.sample.app.storage.models.Item

@Entity(tableName = "photos_table")
data class PhotosResponseModel(
    val description: String,
    val generator: String,
    var items: List<Item>,
    val link: String,
    val modified: String,
    val title: String,
    @PrimaryKey
    val timestamp: Long = System.currentTimeMillis()
)