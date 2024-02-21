package com.kasia.sample.app.domain.repository

import com.kasia.sample.app.domain.models.Item
import kotlinx.coroutines.flow.Flow

interface PhotosRepositoryStorage {

    suspend fun getPhotos(): Flow<List<Item>>

    suspend fun insertPhotos(list: List<Item>)

    fun deleteAllPhotos()
}