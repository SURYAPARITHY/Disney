package com.example.sampleapplicaiton.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapplicaiton.data.db.dao.CharacterDAO
import com.example.sampleapplicaiton.domain.model.DisneyData
import com.example.sampleapplicaiton.domain.usecase.GetDisneyDetailsUseCase
import com.example.sampleapplicaiton.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisneyViewModel @Inject constructor(
    private val getDisneyDetailsUseCase: GetDisneyDetailsUseCase
) : ViewModel() {

    private val _uiState = mutableStateOf<UiState<List<DisneyData>>>(UiState.Loading)
    val uiState: State<UiState<List<DisneyData>>> = _uiState

    fun fetchData() {
        viewModelScope.launch {
            try {
                val characters = getDisneyDetailsUseCase()
                _uiState.value = UiState.Success(characters)
            } catch (e: Exception) {
                _uiState.value = UiState.Error(e.message ?: "Unknown error")
            }
        }
    }
}