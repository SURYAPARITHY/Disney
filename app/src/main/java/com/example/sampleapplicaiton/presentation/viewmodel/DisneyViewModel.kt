package com.example.sampleapplicaiton.presentation.viewmodel

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sampleapplicaiton.domain.model.DisneyData
import com.example.sampleapplicaiton.domain.usecase.GetDisneyDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DisneyViewModel @Inject constructor(
    private val getDisneyDetailsUseCase: GetDisneyDetailsUseCase
) : ViewModel() {

    private val _disneyDataDetails = mutableStateOf<List<DisneyData>>(emptyList())
    val disneyDataDetails: State<List<DisneyData>> get() = _disneyDataDetails

    init {
        viewModelScope.launch {
            _disneyDataDetails.value = getDisneyDetailsUseCase()
        }
    }
}