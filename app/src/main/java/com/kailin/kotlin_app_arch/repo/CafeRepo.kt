package com.kailin.kotlin_app_arch.repo

import com.kailin.kotlin_app_arch.model.CafeNomad
import com.kailin.kotlin_app_arch.model.CafeState
import kotlinx.coroutines.flow.Flow

interface CafeRepo {

    val repoState: Flow<CafeState>
}