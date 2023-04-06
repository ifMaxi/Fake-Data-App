package com.example.fakedataapp.ui.screens

import com.example.fakedataapp.data.model.PostFakeDataItem

/**
 * The state of the UI.
 */
sealed interface UiState {
    data class Success(val fakeList: List<PostFakeDataItem>): UiState
    object Loading: UiState
    object Error: UiState
}
