package tw.idv.kailin.kotlin.cafe.ui.screen.cafe

import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.model.CafeState
import tw.idv.kailin.kotlin.cafe.model.RepoStatus

data class CafeUiState(
    val cafes: List<CafeNomad>,
    val cafeState: CafeState = CafeState(RepoStatus.Loading)
)