package com.kasia.sample.app.storage.di

import com.kasia.sample.app.domain.repository.PhotosRepository
import com.kasia.sample.app.domain.usecases.GetAllPhotosUseCase
import com.kasia.sample.app.domain.usecases.RefreshPhotosDataUseCase
import com.kasia.sample.app.storage.usecase.GetAllPhotosUseCaseImpl
import com.kasia.sample.app.storage.usecase.RefreshPhotosDataUseCaseImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    @Provides
    @Singleton
    fun provideGetAllPhotosUseCase(
        photosRepository: PhotosRepository
    ): GetAllPhotosUseCase =
        GetAllPhotosUseCaseImpl(photosRepository)

    @Provides
    @Singleton
    fun provideRefreshPhotosDataUseCase(
        photosRepository: PhotosRepository
    ): RefreshPhotosDataUseCase =
        RefreshPhotosDataUseCaseImpl(photosRepository)
}