package com.kailin.kotlin_app_arch.repo.ds

import com.kailin.kotlin_app_arch.api.CafeApi
import com.kailin.kotlin_app_arch.ext.apiFlow
import com.kailin.kotlin_app_arch.model.CafeNomad
import com.kailin.kotlin_app_arch.model.CafeState
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CafeApiSourceImpl @Inject constructor(private val api: CafeApi) : CafeApiSource {
    override val cafes: Flow<CafeState> = apiFlow(CafeState::class) { api.cafes("") }
}