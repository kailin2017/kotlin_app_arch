package tw.idv.kailin.kotlin.cafe.repo.ds

import tw.idv.kailin.kotlin.cafe.CafeApi
import tw.idv.kailin.kotlin.cafe.apiFlow
import tw.idv.kailin.kotlin.cafe.CafeState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CafeApiSourceImpl @Inject constructor(private val api: CafeApi) : CafeApiSource {
    override val cafes: Flow<CafeState> = apiFlow(CafeState::class) { api.cafes("") }
}