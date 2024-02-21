package com.kasia.sample.app.network.di

import com.kasia.sample.app.domain.repository.PhotosRepositoryNetwork
import com.kasia.sample.app.network.repository.PhotosRepositoryNetworkImpl
import com.kasia.sample.app.network.service.PhotoService
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object RepositoryNetworkModule {

    @Provides
    @Singleton
    fun bindPhotosRepositoryNetwork(service: PhotoService): PhotosRepositoryNetwork = PhotosRepositoryNetworkImpl(service)
}