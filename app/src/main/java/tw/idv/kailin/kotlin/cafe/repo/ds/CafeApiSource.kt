package tw.idv.kailin.kotlin.cafe.repo.ds

import tw.idv.kailin.kotlin.cafe.CafeState
import kotlinx.coroutines.flow.Flow

interface CafeApiSource {

    val cafes: Flow<CafeState>
}