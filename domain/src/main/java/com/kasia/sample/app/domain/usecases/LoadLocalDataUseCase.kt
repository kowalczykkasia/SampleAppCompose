package com.kasia.sample.app.domain.usecases

import com.kasia.sample.app.domain.models.Item
import kotlinx.coroutines.flow.Flow

interface LoadLocalDataUseCase {
    suspend fun execute() : Flow<List<Item>>
}