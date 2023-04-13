package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import tw.idv.kailin.kotlin.cafe.model.RepoStatus

enum class HomeRoute { List, Map }

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val uiState by viewModel.uiState.collectAsState()
    Scaffold(
        bottomBar = {
            HomeBottomBar(modifier, uiState.selected, viewModel::setSelected)
        }) {
        if (uiState.cafeState.status == RepoStatus.Loading) {
            HomeLoading(modifier)
        } else {
            HomeContent(modifier, navController, uiState.selected)
        }
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

@Composable
fun HomeLoading(
    modifier: Modifier = Modifier,
) {
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

@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    selectedRoute: HomeRoute
) {
    when (selectedRoute) {
        HomeRoute.List -> HomeListScreen(modifier, navController, hiltViewModel())
        HomeRoute.Map -> HomeMapScreen(modifier, navController)
    }
}





