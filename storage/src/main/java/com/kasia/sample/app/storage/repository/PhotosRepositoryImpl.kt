package com.kasia.sample.app.storage.repository

import com.kasia.sample.app.storage.db.dao.PhotosDao
import com.kasia.sample.app.storage.service.Service

class PhotosRepositoryImpl(
    private val service: Service,
    private val dao: PhotosDao
): PhotosRepository {

    override fun getPhotos() = dao.getAllPhotos()

    override suspend fun insertPhotos() {
        dao.insertPhotosResponseModel(service.getPhotos())
    }

    override fun deleteAllPhotos() {
        dao.deleteAll()
    }
}