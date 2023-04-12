package tw.idv.kailin.kotlin.cafe.ui.screen.home

import tw.idv.kailin.kotlin.cafe.model.CafeNomad

data class HomeListUiState(
    val cafes: List<CafeNomad> = listOf()
)