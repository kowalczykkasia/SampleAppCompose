package com.kasia.sample.app.storage.service

import com.kasia.sample.app.storage.BuildConfig
import com.kasia.sample.app.domain.models.Item
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface Service {

    @GET("v1/images")
    suspend fun getPhotos(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
        @Header("x-api-key") apiKey: String = BuildConfig.API_KEY
    ): List<Item>
}