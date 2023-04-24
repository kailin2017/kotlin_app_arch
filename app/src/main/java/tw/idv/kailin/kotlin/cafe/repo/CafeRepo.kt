package tw.idv.kailin.kotlin.cafe.repo

import tw.idv.kailin.kotlin.cafe.model.CafeState
import kotlinx.coroutines.flow.Flow
import tw.idv.kailin.kotlin.cafe.model.CafeNomad

interface CafeRepo {

    val repoState: Flow<CafeState>
    val cafeFlow: Flow<CafeState>
    val cafes: Flow<List<CafeNomad>>
    val cities: Flow<List<String>>

    fun cafes(vararg cities: String): Flow<List<CafeNomad>>

    fun cafes(
        tasty: Float,
        cheap: Float,
        quiet: Float,
        music: Float,
        seat: Float,
        wifi: Float,
        vararg cities: String
    ): Flow<List<CafeNomad>>
}