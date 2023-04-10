package com.kailin.kotlin_app_arch.ui.screen.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kailin.kotlin_app_arch.ui.screen.cafe.CafeScreen

enum class MainScreen {
    Cafe
}

@Composable
fun MainApp(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.Cafe.name,
        modifier = modifier
    ) {
        composable(route = MainScreen.Cafe.name) {
            CafeScreen(viewModel = hiltViewModel())
        }
    }
}
