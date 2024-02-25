package com.kasia.sample.app.storage.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.kasia.sample.app.domain.models.Item

@Entity(tableName = "photos_table")
data class ItemModel(
    val createdAt: String,
    val height: Int,
    @PrimaryKey val id: String,
    val originalFilename: String,
    val subId: String?,
    val url: String,
    val width: Int
) {
    constructor() : this("", 0, "", "", "", "", 0)

    fun toItem() = Item(createdAt, height, id, originalFilename, subId, url, width)
    companion object {

        fun fromItem(item: Item) = ItemModel(item.createdAt, item.height, item.id, item.originalFilename, item.subId, item.url, item.width)
    }
}