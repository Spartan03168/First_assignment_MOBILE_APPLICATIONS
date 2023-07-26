import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.savedstate.SavedStateRegistryOwner
import com.example.proj_3.mainViewModel
import com.example.proj_3.UnsplashApiService

class MainViewModelFactory(
    private val apiService: UnsplashApiService,
    owner: SavedStateRegistryOwner
) : AbstractSavedStateViewModelFactory(owner, /*default args*/ null) {
    override fun <T : ViewModel> create(
        key: String,
        modelClass: Class<T>,
        handle: SavedStateHandle
    ): T {
        if (modelClass.isAssignableFrom(mainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return mainViewModel(apiService, handle) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
