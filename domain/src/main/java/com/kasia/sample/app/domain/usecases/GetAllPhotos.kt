package com.kasia.sample.app.domain.usecases

import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.repository.PhotosRepository
import kotlinx.coroutines.flow.Flow

interface GetAllPhotosUseCase {
    fun execute() : Flow<List<Item>>
}