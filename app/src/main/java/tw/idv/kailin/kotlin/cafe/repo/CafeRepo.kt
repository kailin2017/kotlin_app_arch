package tw.idv.kailin.kotlin.cafe.repo

import tw.idv.kailin.kotlin.cafe.CafeState
import kotlinx.coroutines.flow.Flow

interface CafeRepo {

    val repoState: Flow<CafeState>
}