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
        cities()
        cafes()
    }

    fun setSelectCity(city: String, selected: Boolean) {
        val selectedCities = _uiState.value.selectedCities.toMutableList()
        if (selected) {
            selectedCities.add(city)
        } else {
            selectedCities.remove(city)
        }
        _uiState.update { state ->
            state.copy(selectedCities = selectedCities)
        }
        cafes(*selectedCities.toTypedArray())
    }

    fun dialogExpanded(expanded: Boolean) {
        _uiState.update { state ->
            state.copy(dialogExpanded = expanded)
        }
    }

    private fun cafes(vararg cities: String) {
      viewModelScope.launch {
          if (cities.isEmpty()) {
              cafeRepo.cafes
          } else {
              cafeRepo.cafes(*cities)
          }.collect{
                println("cafeRepo.cafes().collect ${it.size}")
                _uiState.update { state -> state.copy(cafes = it) }
          }
      }
    }

    private fun cities(){
        viewModelScope.launch {
            cafeRepo.cities.collect {
                println("cafeRepo.cities.collect ${it.size}")
                _uiState.update { state -> state.copy(cities = it) }
            }
        }
    }
}