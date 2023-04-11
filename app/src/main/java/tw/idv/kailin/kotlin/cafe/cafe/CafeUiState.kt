package tw.idv.kailin.kotlin.cafe.ui.screen.cafe

import tw.idv.kailin.kotlin.cafe.CafeNomad
import tw.idv.kailin.kotlin.cafe.CafeState
import tw.idv.kailin.kotlin.cafe.RepoStatus

data class CafeUiState(
    val cafes: List<CafeNomad>,
    val cafeState: CafeState = CafeState(RepoStatus.Loading)
)