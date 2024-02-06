package com.kasia.sample.app.storage.service

import com.kasia.sample.app.storage.models.PhotosResponseModel
import retrofit2.http.GET
import retrofit2.http.Query

interface Service {

    @GET("photos_public.gne")
    suspend fun getPhotos(
        @Query("format") format: String = "json",
        @Query("tags") tags: String = "cat",
        @Query("nojsoncallback") noJsonCallback: Int = 1, //todo
    ): PhotosResponseModel
}