package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import tw.idv.kailin.kotlin.cafe.repo.CafeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tw.idv.kailin.kotlin.cafe.model.CafeState
import tw.idv.kailin.kotlin.cafe.model.RepoStatus
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cafeRepo: CafeRepo
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            cafeRepo.cafeFlow.collect {
                _uiState.update { s ->
                    s.copy(cafeState = it)
                }
            }
        }
        viewModelScope.launch {
            cafeRepo.cities.collect {
                _uiState.update { state ->
                    state.copy(cities = it)
                }
            }
        }
    }

    fun setSelectedTab(route: HomeRoute) {
        _uiState.update {
            it.copy(selectedTab = route)
        }
    }

    fun setSelectCity(vararg cities: String) {
        viewModelScope.launch {
            if (cities.isEmpty()) {
                cafeRepo.cafes
            } else {
                cafeRepo.cafes(*cities)
            }.collect {
                println("cafeRepo.cafes().collect ${it.size}")
                _uiState.update { state ->
                    state.copy(
                        selectedCities = cities.toList(),
                        cafeState = CafeState(RepoStatus.Success, data = it),
                    )
                }
            }
        }
    }

    fun dialogExpanded(expanded: Boolean) {
        _uiState.update { state ->
            state.copy(dialogExpanded = expanded)
        }
    }
}