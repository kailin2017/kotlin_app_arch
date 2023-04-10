package com.kailin.kotlin_app_arch.ui.screen.cafe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kailin.kotlin_app_arch.repo.CafeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CafeViewModel @Inject constructor(
    private val cafeRepo: CafeRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(CafeUiState())
    val uiState: StateFlow<CafeUiState> = _uiState

    fun fetchCafe(){
        viewModelScope.launch {
            cafeRepo.cafes().collect {
                _uiState.update { uiState ->
                    uiState.copy(cafeState = it)
                }
            }
        }
    }
}