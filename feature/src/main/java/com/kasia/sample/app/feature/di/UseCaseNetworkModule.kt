package com.kasia.sample.app.feature.di

import com.kasia.sample.app.domain.usecases.FetchAndSaveDataUseCase
import com.kasia.sample.app.domain.usecases.LoadLocalDataUseCase
import com.kasia.sample.app.feature.usecase.FetchAndSaveDataUseCaseImpl
import com.kasia.sample.app.feature.usecase.LoadLocalDataUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseNetworkModule {

    @Binds
    abstract fun bindFetchAndSaveDataUseCase(fetchAndSaveDataUseCaseImpl: FetchAndSaveDataUseCaseImpl) : FetchAndSaveDataUseCase

    @Binds
    abstract fun bindLoadLocalDataUseCase(loadLocalDataUseCaseImpl: LoadLocalDataUseCaseImpl) : LoadLocalDataUseCase
}