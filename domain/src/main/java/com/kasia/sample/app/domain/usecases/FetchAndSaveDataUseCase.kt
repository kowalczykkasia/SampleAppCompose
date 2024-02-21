package com.kasia.sample.app.domain.usecases

import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.models.Result

interface FetchAndSaveDataUseCase {
    suspend fun execute() : Result<List<Item>>
}