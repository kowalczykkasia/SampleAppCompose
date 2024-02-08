package com.kasia.sample.app.storage.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kasia.sample.app.storage.db.dao.PhotosDao
import com.kasia.sample.app.storage.models.Item

@Database(
    entities = [
        Item::class
    ],
    version = VERSION_NUMBER, exportSchema = false
)

abstract class AppDatabase : RoomDatabase() {

    abstract fun photosDao(): PhotosDao

    companion object {
        @Volatile
        private var instance: AppDatabase? = null

        fun getInstance(
            context: Context
        ): AppDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it }
            }
        }

        private fun buildDatabase(
            context: Context
        ): AppDatabase {
            return Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).fallbackToDestructiveMigration().build()
        }
    }

}