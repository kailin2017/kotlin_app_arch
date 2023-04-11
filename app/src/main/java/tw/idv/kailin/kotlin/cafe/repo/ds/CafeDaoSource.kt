package tw.idv.kailin.kotlin.cafe.repo.ds

import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import kotlinx.coroutines.flow.Flow


interface CafeDaoSource {

    val cafes: Flow<List<CafeNomad>>

    suspend fun insert(vararg cafeNomad: CafeNomad)
}