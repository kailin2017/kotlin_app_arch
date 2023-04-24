package tw.idv.kailin.kotlin.cafe.repo.ds

import tw.idv.kailin.kotlin.cafe.dao.CafeDao
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CafeDaoSourceImpl @Inject constructor(private val dao: CafeDao) : CafeDaoSource {

    override val cafeCount: Flow<Int> = dao.getCafeCount()

    override val cafes: Flow<List<CafeNomad>> = dao.getCafes()

    override val cities: Flow<List<String>> = dao.getCities()

    override suspend fun insert(vararg cafeNomad: CafeNomad) = dao.insert(*cafeNomad)

    override fun cafes(vararg cities: String): Flow<List<CafeNomad>> = dao.getCafes(*cities)

    override fun cafes(
        tasty: Float,
        cheap: Float,
        quiet: Float,
        music: Float,
        seat: Float,
        wifi: Float, vararg cities: String
    ): Flow<List<CafeNomad>> = dao.getCafes(tasty, cheap, quiet, music, seat, wifi, *cities)

    override fun cities(): Flow<List<String>> = dao.getCities()
}