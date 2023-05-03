package tw.idv.kailin.kotlin.cafe.ui.screen.home

import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.model.CafeState
import tw.idv.kailin.kotlin.cafe.model.RepoStatus

data class HomeUiState(
    val cities: List<String> = listOf(),
    val cafes: List<CafeNomad> = listOf(),
    val loading: Boolean = false,
    val selectedCities: List<String> = listOf(),
    val filterState: HomeFilterState = HomeFilterState(),
    val dialogExpanded: Boolean = false,
    val selectedTab: HomeRoute = HomeRoute.List,
    val message: String = "",
)