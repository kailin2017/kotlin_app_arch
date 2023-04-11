package tw.idv.kailin.kotlin.cafe.repo.ds

import tw.idv.kailin.kotlin.cafe.model.CafeState
import kotlinx.coroutines.flow.Flow

interface CafeApiSource {

    val cafes: Flow<CafeState>
}