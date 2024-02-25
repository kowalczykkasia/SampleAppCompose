package com.kasia.sample.app.feature.usecase

import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.repository.PhotosRepositoryStorage
import com.kasia.sample.app.domain.usecases.LoadLocalDataUseCase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LoadLocalDataUseCaseImpl @Inject constructor(
    private val storageRepository: PhotosRepositoryStorage
) : LoadLocalDataUseCase {

    override suspend fun execute(): Flow<List<Item>> = storageRepository.getPhotos()
}