package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import tw.idv.kailin.kotlin.cafe.repo.CafeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cafeRepo: CafeRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            cafeRepo.repoState.collect {
                println("cafeRepo.repoState.collect ${it.status}")
                _uiState.update { s ->
                    s.copy(cafeState = it)
                }
            }
        }
    }

    fun setSelected(route: HomeRoute) {
        _uiState.update {
            it.copy(selected = route)
        }
    }
}