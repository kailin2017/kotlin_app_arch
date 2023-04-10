package com.kailin.kotlin_app_arch.repo

import com.kailin.kotlin_app_arch.model.CafeState
import kotlinx.coroutines.flow.Flow

interface CafeRepo {

    suspend fun cafes(city: String = ""): Flow<CafeState>
}