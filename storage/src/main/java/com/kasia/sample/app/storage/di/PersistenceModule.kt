package com.kasia.sample.app.storage.di

import android.content.Context
import com.kasia.sample.app.storage.db.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {

    @Provides
    @Singleton
    fun provideAppDataBase(
        @ApplicationContext context: Context
    ) = AppDatabase.getInstance(context)
}