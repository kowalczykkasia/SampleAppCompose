package com.kasia.sample.app.storage.repository

import com.kasia.sample.app.storage.models.Item
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    fun getPhotos(): Flow<List<Item>>

    suspend fun insertPhotos()

    fun deleteAllPhotos()
}