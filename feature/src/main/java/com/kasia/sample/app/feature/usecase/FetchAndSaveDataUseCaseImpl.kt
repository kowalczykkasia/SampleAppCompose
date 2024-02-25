package com.kasia.sample.app.feature.usecase

import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.models.Result
import com.kasia.sample.app.domain.repository.PhotosRepositoryNetwork
import com.kasia.sample.app.domain.repository.PhotosRepositoryStorage
import com.kasia.sample.app.domain.usecases.FetchAndSaveDataUseCase
import javax.inject.Inject

internal class FetchAndSaveDataUseCaseImpl @Inject constructor(
    private val networkRepository: PhotosRepositoryNetwork,
    private val storageRepository: PhotosRepositoryStorage
) : FetchAndSaveDataUseCase {

    override suspend fun execute(): Result<List<Item>> =
        try {
            val response = networkRepository.fetchPhotos()
            storageRepository.deleteAllPhotos()
            storageRepository.insertPhotos(response)
            Result.Success(response)
        } catch (e: Exception) {
            Result.Error(e)
        }
}