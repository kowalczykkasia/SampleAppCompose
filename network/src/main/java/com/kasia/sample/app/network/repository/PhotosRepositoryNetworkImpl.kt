package com.kasia.sample.app.network.repository

import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.repository.PhotosRepositoryNetwork
import com.kasia.sample.app.network.service.PhotoService
internal class PhotosRepositoryNetworkImpl (
    private val service: PhotoService
): PhotosRepositoryNetwork {
    override suspend fun fetchPhotos(): List<Item> = service.getPhotos().map {
        it.toItem()
    }
}