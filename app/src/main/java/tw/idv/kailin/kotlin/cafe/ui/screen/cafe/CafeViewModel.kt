package tw.idv.kailin.kotlin.cafe.ui.screen.cafe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import tw.idv.kailin.kotlin.cafe.repo.cafe.CafeRepo
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
//            cafeRepo.repoState.collect {
//                _uiState.update { s ->
//                    s.copy(cafeState = it, cafes = it.data ?: listOf())
//                }
//            }
        }
    }
}