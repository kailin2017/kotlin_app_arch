package com.kailin.kotlin_app_arch.ui.screen.cafe

import com.kailin.kotlin_app_arch.model.CafeState
import com.kailin.kotlin_app_arch.model.RepoStatus

data class CafeUiState(val cafeState: CafeState = CafeState(RepoStatus.Loading))