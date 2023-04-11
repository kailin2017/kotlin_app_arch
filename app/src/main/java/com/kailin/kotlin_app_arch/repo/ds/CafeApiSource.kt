package com.kailin.kotlin_app_arch.repo.ds

import com.kailin.kotlin_app_arch.model.CafeState
import kotlinx.coroutines.flow.Flow

interface CafeApiSource {

    val cafes: Flow<CafeState>
}