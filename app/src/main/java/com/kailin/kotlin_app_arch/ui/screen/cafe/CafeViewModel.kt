package com.kailin.kotlin_app_arch.ui.screen.cafe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kailin.kotlin_app_arch.model.CafeState
import com.kailin.kotlin_app_arch.model.RepoStatus
import com.kailin.kotlin_app_arch.repo.CafeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CafeViewModel @Inject constructor(
    private val cafeRepo: CafeRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(CafeUiState(listOf()))
    val uiState: StateFlow<CafeUiState> = _uiState

    init {
        viewModelScope.launch {
            cafeRepo.repoState.collect {
                _uiState.update { s ->
                    s.copy(cafeState = it, cafes = it.data ?: listOf())
                }
            }
        }
    }
}