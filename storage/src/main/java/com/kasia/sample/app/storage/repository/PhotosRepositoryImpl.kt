package com.kasia.sample.app.storage.repository

import com.kasia.sample.app.domain.repository.PhotosRepository
import com.kasia.sample.app.storage.db.ItemModel
import com.kasia.sample.app.storage.db.dao.PhotosDao
import com.kasia.sample.app.storage.service.Service
import kotlinx.coroutines.flow.map

class PhotosRepositoryImpl(
    private val service: Service,
    private val dao: PhotosDao
): PhotosRepository {

    override fun getPhotos() = dao.getAllPhotos().map { it.map { it.toItem() } } //todo mapping here?

    override suspend fun insertPhotos() {
        dao.insertNewPhotos(service.getPhotos().map {
            ItemModel.fromItem(it) //todo mapping here?
        })
    }

    override fun deleteAllPhotos() {
        dao.deleteAll()
    }
}