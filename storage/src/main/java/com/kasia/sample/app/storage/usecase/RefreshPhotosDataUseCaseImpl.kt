package com.kasia.sample.app.storage.usecase

import com.kasia.sample.app.domain.repository.PhotosRepository
import com.kasia.sample.app.domain.usecases.RefreshPhotosDataUseCase

class RefreshPhotosDataUseCaseImpl(
    private val photosRepository: PhotosRepository
) : RefreshPhotosDataUseCase {
    override suspend fun execute() {
        photosRepository.deleteAllPhotos()
        photosRepository.insertPhotos()
    }
}