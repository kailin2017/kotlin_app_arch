package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

enum class HomeRoute { List, Map }

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        topBar = {
            HomeTopBar(selectedCities = uiState.filterState.cities) {
                viewModel.dialogExpanded(true)
            }
        },
        bottomBar = {
            HomeBottomBar(modifier, uiState.selectedTab, viewModel::setSelectedTab)
        },
    ) {
        when (uiState.selectedTab) {
            HomeRoute.List -> HomeListScreen(modifier.padding(it), navController, viewModel)
            HomeRoute.Map -> HomeMapScreen(modifier.padding(it), navController, viewModel)
        }
    }
    if (uiState.dialogExpanded) {
        FilterDialogScreen(
            cities = uiState.cities,
            filter = uiState.filterState,
            onDismiss = { viewModel.dialogExpanded(false) },
        ) {
            viewModel.dialogExpanded(false)
            viewModel.filter(it)
        }
    }
}

@Composable
fun HomeTopBar(
    selectedCities: List<String>,
    onShowFilter: () -> Unit
) {
    val typography = MaterialTheme.typography
    val selectedCitiesTest = if (selectedCities.isEmpty()) {
        "All"
    } else {
        selectedCities.joinToString(" , ")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onShowFilter)
            .padding(16.dp)
    ) {
        Text(
            text = "Filter City : $selectedCitiesTest",
            style = typography.bodyMedium
        )
    }
}

@Composable
fun HomeBottomBar(
    modifier: Modifier = Modifier,
    selectedRoute: HomeRoute = HomeRoute.List,
    onSelectedRoute: (HomeRoute) -> Unit
) {
    val items = listOf(HomeRoute.List, HomeRoute.Map)
    NavigationBar(modifier = modifier) {
        items.forEach {
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = it.name) },
                label = { Text(it.name) },
                selected = selectedRoute == it,
                onClick = { onSelectedRoute(it) }
            )
        }
    }
}




