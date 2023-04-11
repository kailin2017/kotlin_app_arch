package com.kailin.kotlin_app_arch.repo.ds

import com.kailin.kotlin_app_arch.model.CafeNomad
import kotlinx.coroutines.flow.Flow


interface CafeDaoSource {

    val cafes: Flow<List<CafeNomad>>

    suspend fun insert(vararg cafeNomad: CafeNomad)
}