package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

@Composable
fun HomeListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    Text(text = "HomeListScreen")
}