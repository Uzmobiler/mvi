package uz.mobiler.mvi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import uz.mobiler.mvi.network.ApiService
import uz.mobiler.mvi.repository.MainRepository

class ViewModelFactory(private val apiService: ApiService) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(MainRepository(apiService)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}