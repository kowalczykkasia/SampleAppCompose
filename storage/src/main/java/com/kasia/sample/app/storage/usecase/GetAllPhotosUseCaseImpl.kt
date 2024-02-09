package com.kasia.sample.app.storage.usecase

import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.repository.PhotosRepository
import com.kasia.sample.app.domain.usecases.GetAllPhotosUseCase
import com.kasia.sample.app.storage.db.ItemModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetAllPhotosUseCaseImpl(
    private val photosRepository: PhotosRepository
) : GetAllPhotosUseCase {
    override fun execute(): Flow<List<Item>> = photosRepository.getPhotos()
}