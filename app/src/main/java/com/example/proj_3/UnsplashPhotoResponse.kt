package com.example.proj_3


data class UnsplashPhotoResponse(
    val id: String,
    val description: String?,
    val urls: UnsplashPhotoUrls
)

data class UnsplashPhotoUrls(
    val regular: String
)

