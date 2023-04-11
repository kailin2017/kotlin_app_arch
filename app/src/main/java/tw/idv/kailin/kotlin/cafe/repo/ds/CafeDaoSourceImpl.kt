package tw.idv.kailin.kotlin.cafe.repo.ds

import tw.idv.kailin.kotlin.cafe.dao.CafeDao
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CafeDaoSourceImpl @Inject constructor(private val dao: CafeDao) : CafeDaoSource {

    override val cafes: Flow<List<CafeNomad>> = dao.getFlow()

    override suspend fun insert(vararg cafeNomad: CafeNomad) = dao.insert(*cafeNomad)
}