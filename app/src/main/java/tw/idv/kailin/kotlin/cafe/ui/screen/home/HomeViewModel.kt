package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import tw.idv.kailin.kotlin.cafe.model.CafeState
import tw.idv.kailin.kotlin.cafe.model.RepoStatus
import tw.idv.kailin.kotlin.cafe.repo.global.GlobalRepo
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val cafeRepo: CafeRepo,
    private val globalRepo: GlobalRepo,
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            cafeRepo.cities.collect {
                _uiState.update { state ->
                    state.copy(cities = it)
                }
            }
        }
        viewModelScope.launch {
            cafeRepo.cafes.collect {
                _uiState.update { state ->
                    state.copy(cafes = it)
                }
            }
        }
        viewModelScope.launch {
            cafeRepo.updateCafes()
        }
        viewModelScope.launch {
            globalRepo.message.collect {
                println("globalRepo.message.collect $it")
                _uiState.update { state ->
                    state.copy(message = it)
                }
            }
        }
    }

    fun setSelectedTab(route: HomeRoute) {
        _uiState.update {
            it.copy(selectedTab = route)
        }
    }

    fun filter(filterState: HomeFilterState) {
        viewModelScope.launch {
            cafeRepo.filterCafes(
                filterState.tasty,
                filterState.cheap,
                filterState.quiet,
                filterState.music,
                filterState.seat,
                filterState.wifi,
                *filterState.cities.toTypedArray()
            ).collect {
                _uiState.update { state ->
                    state.copy(
                        cafes = it,
                        filterState = filterState
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