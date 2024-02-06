package com.kasia.sample.app.storage.usecases

import com.kasia.sample.app.storage.models.PhotosResponseModel
import com.kasia.sample.app.storage.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

interface GetAllPhotosUseCase {
    fun execute() : Flow<List<PhotosResponseModel>>
}

class GetAllPhotosUseCaseImpl(
    private val photosRepository: PhotosRepository
) : GetAllPhotosUseCase {
    override fun execute(): Flow<List<PhotosResponseModel>> {
        return photosRepository.getPhotos()
    }
}