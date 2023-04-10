package com.kailin.kotlin_app_arch.repo

import com.kailin.kotlin_app_arch.api.CafeApi
import com.kailin.kotlin_app_arch.ext.retrofitFlow
import com.kailin.kotlin_app_arch.model.CafeState
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CafeRepoImpl @Inject constructor(private val service: CafeApi) : CafeRepo {

    override suspend fun cafes(city: String): Flow<CafeState> = retrofitFlow(CafeState::class) {
        service.cafes(city)
    }
}
