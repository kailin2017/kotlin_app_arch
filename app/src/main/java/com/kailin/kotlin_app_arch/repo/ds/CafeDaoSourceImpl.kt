package com.kailin.kotlin_app_arch.repo.ds

import com.kailin.kotlin_app_arch.dao.CafeDao
import com.kailin.kotlin_app_arch.model.CafeNomad
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CafeDaoSourceImpl @Inject constructor(private val dao: CafeDao) : CafeDaoSource {

    override val cafes: Flow<List<CafeNomad>> = dao.getFlow()

    override suspend fun insert(vararg cafeNomad: CafeNomad) = dao.insert(*cafeNomad)
}