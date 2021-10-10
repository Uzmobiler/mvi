package uz.mobiler.mvi.repository

import uz.mobiler.mvi.network.ApiService

class MainRepository(private val apiService: ApiService) {
    suspend fun getUsers() = apiService.getUsers()
}