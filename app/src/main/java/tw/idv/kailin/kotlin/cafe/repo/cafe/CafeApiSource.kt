package tw.idv.kailin.kotlin.cafe.repo.cafe

import kotlinx.coroutines.flow.Flow
import tw.idv.kailin.kotlin.cafe.model.CafeNomad

interface CafeApiSource {

    suspend fun cafes(): List<CafeNomad>
}