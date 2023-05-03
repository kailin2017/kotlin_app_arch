package tw.idv.kailin.kotlin.cafe.repo.cafe

import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import kotlinx.coroutines.flow.Flow


interface CafeDaoSource {

    val cafeCount: Flow<Int>

    val cafes: Flow<List<CafeNomad>>

    val cities: Flow<List<String>>

    suspend fun insert(vararg cafeNomad: CafeNomad)

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