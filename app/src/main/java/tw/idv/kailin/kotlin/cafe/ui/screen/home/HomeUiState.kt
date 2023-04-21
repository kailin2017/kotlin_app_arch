package tw.idv.kailin.kotlin.cafe.ui.screen.home

import tw.idv.kailin.kotlin.cafe.model.CafeState
import tw.idv.kailin.kotlin.cafe.model.RepoStatus

data class HomeUiState(
    val cafeState: CafeState = CafeState(RepoStatus.Loading),
    val cities: List<String> = listOf(),
    val selectedCities: List<String> = listOf(),
    val dialogExpanded: Boolean = false,
    val selectedTab: HomeRoute = HomeRoute.List,
)