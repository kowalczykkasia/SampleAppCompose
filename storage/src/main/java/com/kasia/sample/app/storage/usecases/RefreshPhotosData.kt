package com.kasia.sample.app.storage.usecases

import com.kasia.sample.app.storage.repository.PhotosRepository

interface RefreshPhotosDataUseCase {
    suspend fun execute()
}

class RefreshPhotosDataUseCaseImpl(
    private val photosRepository: PhotosRepository
) : RefreshPhotosDataUseCase {
    override suspend fun execute() {
        photosRepository.deleteAllPhotos()
        photosRepository.insertPhotos()
    }
}