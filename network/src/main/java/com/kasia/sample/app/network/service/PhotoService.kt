package com.kasia.sample.app.network.service

import com.kasia.sample.app.network.BuildConfig
import com.kasia.sample.app.network.model.ItemResponseModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

internal interface PhotoService {

    @GET("v1/images")
    suspend fun getPhotos(
        @Query("limit") limit: Int = 10,
        @Query("page") page: Int = 0,
        @Header("x-api-key") apiKey: String = BuildConfig.API_KEY
    ): List<ItemResponseModel>
}