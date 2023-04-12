package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun HomeListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HomeListViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    val typography = MaterialTheme.typography
    LazyColumn(modifier.padding(16.dp)) {
        items(uiState.cafes) {
            Card(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = modifier.padding(16.dp)) {
                    Text(text = it.name, style = typography.bodyLarge)
                    Box(modifier = modifier.height(8.dp))
                    Row(modifier = modifier.fillMaxWidth()) {
                        Text(
                            text = "咖啡:${it.tasty}★",
                            style = typography.bodyMedium,
                            modifier = modifier.weight(1f)
                        )
                        Text(
                            text = "價格:${it.cheap}★",
                            style = typography.bodyMedium,
                            modifier = modifier.weight(1f)
                        )
                    }
                    Row(modifier = modifier.fillMaxWidth()) {
                        Text(
                            text = "安靜:${it.quiet}★",
                            style = typography.bodyMedium,
                            modifier = modifier.weight(1f)
                        )
                        Text(
                            text = "音樂:${it.music}★",
                            style = typography.bodyMedium,
                            modifier = modifier.weight(1f)
                        )
                    }
                    Row(modifier = modifier.fillMaxWidth()) {
                        Text(
                            text = "Wi-Fi:${it.wifi}★",
                            style = typography.bodyMedium,
                            modifier = modifier.weight(1f)
                        )
                        Text(
                            text = "座位:${it.seat}★",
                            style = typography.bodyMedium,
                            modifier = modifier.weight(1f)
                        )
                    }
                    Divider(
                        color = Color.Gray,
                        thickness = 1.dp,
                        modifier = Modifier.padding(vertical = 8.dp)
                    )
                    Text(text = it.address, style = typography.bodyMedium)
                }
            }
        }
    }
}