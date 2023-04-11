package tw.idv.kailin.kotlin.cafe.repo

import tw.idv.kailin.kotlin.cafe.model.CafeState
import kotlinx.coroutines.flow.Flow

interface CafeRepo {

    val repoState: Flow<CafeState>
}