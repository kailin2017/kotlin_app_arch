package com.kailin.kotlin_app_arch.ui.screen.cafe

import android.graphics.Color
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kailin.kotlin_app_arch.model.CafeNomad
import com.kailin.kotlin_app_arch.model.RepoStatus
import com.kailin.kotlin_app_arch.ui.theme.Kotlin_app_archTheme

@Composable
fun CafeScreen(
    modifier: Modifier = Modifier,
    viewModel: CafeViewModel = viewModel()
) {
    val uiState by viewModel.uiState.collectAsState()
    Kotlin_app_archTheme {
        Surface(
            modifier = modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
            CafeLayout(modifier, uiState)
        }
    }
}

@Composable
fun CafeLayout(modifier: Modifier = Modifier, cafeUiState: CafeUiState) {
    when (cafeUiState.cafeState.status) {
        RepoStatus.Loading -> CafeLayoutLoading(modifier)
        RepoStatus.Success -> CafeLayoutSuccess(modifier, cafeUiState.cafeState.data ?: listOf())
        else -> CafeLayoutLoading(modifier)
    }
}

@Composable
fun CafeLayoutSuccess(modifier: Modifier = Modifier, list: List<CafeNomad>) {
    LazyColumn(modifier = modifier) {
        items(list) {
            Column {
                Text(text = it.name, fontSize = 18.sp)
                Text(text = it.address, fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun CafeLayoutLoading(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(modifier = modifier)
    }
}

