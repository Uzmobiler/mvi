package uz.mobiler.mvi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch
import uz.mobiler.mvi.repository.MainIntent
import uz.mobiler.mvi.repository.MainRepository
import uz.mobiler.mvi.repository.MainState

class MainViewModel(
    private val repository: MainRepository
) : ViewModel() {
    val userIntent = Channel<MainIntent>(Channel.UNLIMITED)

    val state = MutableStateFlow<MainState>(MainState.Idle)

    init {
        handleIntent()
    }

    private fun handleIntent() {
        viewModelScope.launch {
            userIntent.consumeAsFlow().collect {
                when (it) {
                    is MainIntent.FetchUser -> fetchUser()
                }
            }
        }
    }

    private fun fetchUser() {
        viewModelScope.launch {
            state.value = MainState.Loading
            state.value = try {
                MainState.Users(repository.getUsers())
            } catch (e: Exception) {
                MainState.Error(e.localizedMessage)
            }
        }
    }
}
