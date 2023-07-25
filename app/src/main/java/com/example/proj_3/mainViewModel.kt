package com.example.proj_3

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.Response



class MainViewModel(private val apiService: UnsplashApiService) : ViewModel() {
    private val _photoDetails = MutableLiveData<UnsplashPhotoResponse>()
    val photoDetails: LiveData<UnsplashPhotoResponse> = _photoDetails

    fun getRandomPhoto() {
        // Replace "YOUR_UNSPLASH_API_KEY" with your actual Unsplash API key
        val apiKey = "ZDT-xxurKeoTFo-Suru4HS7v_Qh0HMv_uMR7GMOGxfQ"

        // Use the coroutine scope to fetch the data asynchronously
        viewModelScope.launch {
            try {
                val response: Response<UnsplashPhotoResponse> = withContext(Dispatchers.IO) {
                    apiService.getRandomPhoto(apiKey)
                }
                if (response.isSuccessful) {
                    val photoResponse = response.body()
                    _photoDetails.value = photoResponse
                } else {
                    // Handle error if needed
                }
            } catch (e: Exception) {
                // Handle error if needed
            }
        }
    }
}

