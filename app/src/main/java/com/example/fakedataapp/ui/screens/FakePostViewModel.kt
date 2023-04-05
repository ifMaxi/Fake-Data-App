package com.example.fakedataapp.ui.screens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.fakedataapp.FakeDataApplication
import com.example.fakedataapp.data.repository.FakePostRepository
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.io.IOException

class FakePostViewModel(
    private val repository: FakePostRepository
): ViewModel() {
    var uiState: UiState by mutableStateOf(UiState.Loading)
        private set

    init {
        getFakeData()
    }

    private fun getFakeData() {
        viewModelScope.launch {
            uiState = UiState.Loading
            uiState = try {
                UiState.Success(repository.obtainPost())
            } catch (e: IOException) {
                UiState.Error
            } catch (e: HttpException) {
                UiState.Error
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FakeDataApplication)
                val fakeRepository = application.container.postRepository
                FakePostViewModel(repository = fakeRepository)
            }
        }
    }
}
