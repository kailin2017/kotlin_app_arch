package tw.idv.kailin.kotlin.cafe.repo.cafe

import kotlinx.coroutines.flow.Flow
import tw.idv.kailin.kotlin.cafe.model.CafeNomad

interface CafeRepo {

    val cities: Flow<List<String>>
    val cafes: Flow<List<CafeNomad>>

    fun filterCafes(
        tasty: Float,
        cheap: Float,
        quiet: Float,
        music: Float,
        seat: Float,
        wifi: Float,
        vararg cities: String
    ): Flow<List<CafeNomad>>

    suspend fun updateCafes()
}