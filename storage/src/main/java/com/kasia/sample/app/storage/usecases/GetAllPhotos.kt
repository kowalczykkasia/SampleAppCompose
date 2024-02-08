package com.kasia.sample.app.storage.usecases

import com.kasia.sample.app.storage.models.Item
import com.kasia.sample.app.storage.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

interface GetAllPhotosUseCase {
    fun execute() : Flow<List<Item>>
}

class GetAllPhotosUseCaseImpl(
    private val photosRepository: PhotosRepository
) : GetAllPhotosUseCase {
    override fun execute(): Flow<List<Item>> {
        return photosRepository.getPhotos()
    }
}