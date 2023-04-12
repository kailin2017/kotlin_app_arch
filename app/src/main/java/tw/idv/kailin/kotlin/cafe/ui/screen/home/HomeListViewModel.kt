package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tw.idv.kailin.kotlin.cafe.repo.CafeRepo
import javax.inject.Inject

@HiltViewModel
class HomeListViewModel @Inject constructor(
    private val cafeRepo: CafeRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeListUiState())
    val uiState: StateFlow<HomeListUiState> = _uiState

    init {
        viewModelScope.launch {
            cafeRepo.filterCafes.collect {
                _uiState.update { state -> state.copy(cafes = it) }
            }
        }
    }

}