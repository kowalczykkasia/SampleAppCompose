package com.kasia.sample.app.storage.repository

import com.kasia.sample.app.domain.models.Item
import com.kasia.sample.app.domain.repository.PhotosRepositoryStorage
import com.kasia.sample.app.storage.db.ItemModel
import com.kasia.sample.app.storage.db.dao.PhotosDao
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class PhotosRepositoryStorageImpl(
    private val dao: PhotosDao
): PhotosRepositoryStorage {

    override suspend fun getPhotos() = dao.getAllPhotos().map { it.map { it.toItem() } }

    override suspend fun insertPhotos(list: List<Item>) {
        dao.insertNewPhotos(list.map {
            ItemModel.fromItem(it)
        })
    }

    override fun deleteAllPhotos() {
        dao.deleteAll()
    }
}