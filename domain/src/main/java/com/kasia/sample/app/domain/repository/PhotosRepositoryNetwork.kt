package com.kasia.sample.app.domain.repository

import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.models.Result
import kotlinx.coroutines.flow.Flow

interface PhotosRepositoryNetwork {

    suspend fun fetchPhotos(): List<Item>

}