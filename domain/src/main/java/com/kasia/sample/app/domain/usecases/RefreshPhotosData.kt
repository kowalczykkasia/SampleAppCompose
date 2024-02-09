package com.kasia.sample.app.domain.usecases

import com.kasia.sample.app.domain.repository.PhotosRepository

interface RefreshPhotosDataUseCase {
    suspend fun execute()
}