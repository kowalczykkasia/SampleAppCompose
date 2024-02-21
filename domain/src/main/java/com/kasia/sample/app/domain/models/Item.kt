package com.kasia.sample.app.domain.models

data class Item(
    val createdAt: String,
    val height: Int,
    val id: String,
    val originalFilename: String,
    val subId: String?,
    val url: String,
    val width: Int
) {
    constructor() : this("", 0, "", "", "", "", 0)
}