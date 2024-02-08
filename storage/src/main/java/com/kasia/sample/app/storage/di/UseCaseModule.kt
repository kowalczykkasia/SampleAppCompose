package com.kasia.sample.app.storage.di

import com.kasia.sample.app.storage.repository.PhotosRepositoryImpl
import com.kasia.sample.app.storage.usecases.GetAllPhotosUseCase
import com.kasia.sample.app.storage.usecases.GetAllPhotosUseCaseImpl
import com.kasia.sample.app.storage.usecases.RefreshPhotosDataUseCase
import com.kasia.sample.app.storage.usecases.RefreshPhotosDataUseCaseImpl
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
        photosRepository: PhotosRepositoryImpl
    ): GetAllPhotosUseCase = GetAllPhotosUseCaseImpl(photosRepository)

    @Provides
    @Singleton
    fun provideRefreshPhotosDataUseCase(
        photosRepository: PhotosRepositoryImpl
    ): RefreshPhotosDataUseCase = RefreshPhotosDataUseCaseImpl(photosRepository)
}