package tw.idv.kailin.kotlin.cafe

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import tw.idv.kailin.kotlin.cafe.ui.screen.cafe.CafeScreen

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
