package tw.idv.kailin.kotlin.cafe.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import tw.idv.kailin.kotlin.cafe.ui.screen.cafe.CafeScreen
import tw.idv.kailin.kotlin.cafe.ui.screen.home.HomeScreen

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout()
        }
    }
}

enum class MainRoute {
    Cafe, Home
}

@Composable
fun MainLayout(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    MainNavHost(modifier, navController)
}

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute.Home.name,
        modifier = modifier
    ) {
        composable(route = MainRoute.Home.name) {
            HomeScreen(modifier, navController, hiltViewModel())
        }
        composable(route = MainRoute.Cafe.name) {
            CafeScreen(modifier, hiltViewModel())
        }
    }
}

