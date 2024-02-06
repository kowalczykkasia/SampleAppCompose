package com.kasia.sample.app.storage.repository

import com.kasia.sample.app.storage.models.PhotosResponseModel
import kotlinx.coroutines.flow.Flow

interface PhotosRepository {

    fun getPhotos(): Flow<List<PhotosResponseModel>>

    suspend fun insertPhotos()

    fun deleteAllPhotos()
}