package tw.idv.kailin.kotlin.cafe.repo.cafe

import tw.idv.kailin.kotlin.cafe.api.CafeApi
import kotlinx.coroutines.flow.Flow
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.util.connect.ConnectManager
import javax.inject.Inject

class CafeApiSourceImpl @Inject constructor(
    private val api: CafeApi,
    private val connectManager: ConnectManager
) : CafeApiSource {

    override suspend fun cafes(): List<CafeNomad> {
        return connectManager.call { api.cafes("") } ?: listOf()
    }
}