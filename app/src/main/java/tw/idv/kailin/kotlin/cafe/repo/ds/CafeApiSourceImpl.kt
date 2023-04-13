package tw.idv.kailin.kotlin.cafe.repo.ds

import tw.idv.kailin.kotlin.cafe.api.CafeApi
import tw.idv.kailin.kotlin.cafe.ext.apiFlow
import tw.idv.kailin.kotlin.cafe.model.CafeState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CafeApiSourceImpl @Inject constructor(private val api: CafeApi) : CafeApiSource {
    override val cafes: Flow<CafeState> = apiFlow(CafeState::class) { api.cafes("") }
}