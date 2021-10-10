package uz.mobiler.mvi.repository

sealed class MainIntent {
    object FetchUser : MainIntent()
}