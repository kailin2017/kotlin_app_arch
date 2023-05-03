package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

sealed class HomeRoute {

    abstract val text: String
    abstract val icon: ImageVector

    object List : HomeRoute() {
        override val text: String = "List"
        override val icon: ImageVector = Icons.Filled.List
    }

    object Map : HomeRoute() {
        override val text: String = "Map"
        override val icon: ImageVector = Icons.Filled.Place
    }
}

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    val filterState = uiState.filterState
    Scaffold(
        topBar = {
            HomeTopBar(filterState, filterState.cities.size == uiState.cities.size) {
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
    state: HomeFilterState,
    selectedAllCities: Boolean,
    onShowFilter: () -> Unit
) {
    val typography = MaterialTheme.typography
    val stringBuilder = StringBuilder()
    if (state.tasty > 0f) {
        stringBuilder.append("咖啡 >= ${state.tasty}\n")
    }
    if (state.cheap > 0f) {
        stringBuilder.append("價錢 >= ${state.cheap}\n")
    }
    if (state.quiet > 0f) {
        stringBuilder.append("安靜 >= ${state.quiet}\n")
    }
    if (state.music > 0f) {
        stringBuilder.append("音樂 >= ${state.music}\n")
    }
    if (state.wifi > 0f) {
        stringBuilder.append("Wi-Fi >= ${state.wifi}\n")
    }
    if (state.seat > 0f) {
        stringBuilder.append("座位 >= ${state.seat}\n")
    }
    if (selectedAllCities || state.cities.isEmpty()) {
        stringBuilder.append("城市：全部")
    } else {
        stringBuilder.append("城市：${state.cities.joinToString(" , ")}")
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable(onClick = onShowFilter)
            .padding(16.dp)
    ) {
        Text(
            text = stringBuilder.toString(),
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
                icon = { Icon(it.icon, contentDescription = it.text) },
                label = { Text(it.text) },
                selected = selectedRoute == it,
                onClick = { onSelectedRoute(it) }
            )
        }
    }
}




