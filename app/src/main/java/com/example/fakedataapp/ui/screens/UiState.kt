package com.example.fakedataapp.ui.screens

import com.example.fakedataapp.data.model.PostFakeDataItem

sealed interface UiState {
    data class Success(val fakeList: List<PostFakeDataItem>): UiState
    object Loading: UiState
    object Error: UiState
}
