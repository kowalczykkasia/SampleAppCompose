package com.kasia.sample.app.storage.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.kasia.sample.app.storage.models.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface PhotosDao {

    @Query("SELECT * FROM photos_table")
    fun getAllPhotos() : Flow<List<Item>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNewPhotos(newItem: List<Item>)

    @Query("DELETE FROM photos_table")
    fun deleteAll()

}