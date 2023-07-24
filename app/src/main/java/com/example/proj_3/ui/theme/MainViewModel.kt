package com.example.proj_3.ui.theme

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proj_3.UnsplashApiService
import com.example.proj_3.UnsplashPhoto
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainViewModel : ViewModel() {
    private val unsplashApi: UnsplashApiService

    init {
        // Create the Retrofit instance
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.unsplash.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Create the API service
        unsplashApi = retrofit.create(UnsplashApiService::class.java)
    }

    // LiveData to hold the photo details
    private val _photoDetails = MutableLiveData<UnsplashPhoto>()
    val photoDetails: LiveData<UnsplashPhoto>
        get() = _photoDetails

    fun getRandomPhoto() {
        viewModelScope.launch {
            try {
                // Make the API call and get the response
                val response = unsplashApi.getRandomPhoto("YOUR_UNSPLASH_API_KEY")

                // If the API call is successful and the response body is not null
                if (response.isSuccessful && response.body() != null) {
                    val photo = response.body()!!
                    _photoDetails.value = photo
                } else {
                    // Handle error here if needed
                }
            } catch (e: Exception) {
                // Handle error here if needed
            }
        }
    }
}