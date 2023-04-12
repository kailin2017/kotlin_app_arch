package tw.idv.kailin.kotlin.cafe.repo

import tw.idv.kailin.kotlin.cafe.model.CafeState
import kotlinx.coroutines.flow.Flow
import tw.idv.kailin.kotlin.cafe.model.CafeNomad

interface CafeRepo {

    val repoState: Flow<CafeState>
    val filterCafes: Flow<List<CafeNomad>>
}