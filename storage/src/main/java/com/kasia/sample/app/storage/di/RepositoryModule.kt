package com.kasia.sample.app.storage.di

import com.kasia.sample.app.storage.db.AppDatabase
import com.kasia.sample.app.storage.repository.PhotosRepository
import com.kasia.sample.app.storage.service.Service
import com.kasia.sample.app.storage.repository.PhotosRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun providePhotosRepository(service: Service, appDatabase: AppDatabase): PhotosRepositoryImpl = PhotosRepositoryImpl(service, appDatabase.photosDao())
}