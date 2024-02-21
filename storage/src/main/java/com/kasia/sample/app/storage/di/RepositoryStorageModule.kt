package com.kasia.sample.app.storage.di

import com.kasia.sample.app.domain.repository.PhotosRepositoryStorage
import com.kasia.sample.app.storage.db.AppDatabase
import com.kasia.sample.app.storage.repository.PhotosRepositoryStorageImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryStorageModule {

    @Provides
    @Singleton
    fun providePhotosRepositoryStorage(appDatabase: AppDatabase): PhotosRepositoryStorage =
        PhotosRepositoryStorageImpl(
            appDatabase.photosDao()
        )
}