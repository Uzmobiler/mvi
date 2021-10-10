package uz.mobiler.mvi.network

import retrofit2.http.GET
import uz.mobiler.mvi.models.User

interface ApiService {
    @GET("users")
    suspend fun getUsers(): List<User>
}