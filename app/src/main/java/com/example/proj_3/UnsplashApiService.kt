package com.example.proj_3

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface UnsplashApiService {
    @GET("/photos/random")
    suspend fun getRandomPhoto(
        @Query("client_id") apiKey: String,
        @Query("query") query: String? = null
    ): Response<UnsplashPhotoResponse>
}