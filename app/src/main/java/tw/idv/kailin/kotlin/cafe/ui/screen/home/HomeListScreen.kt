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
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.model.RepoStatus

@Composable
fun HomeListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    if (uiState.cafes.isEmpty()) {
        CircularProgressIndicator(modifier = modifier)
    } else {
        LazyColumn(modifier = modifier.fillMaxWidth()) {
            items(uiState.cafes) { HomeListItem(it) }
        }
    }
}

@Composable
fun HomeListItem(cafeNomad: CafeNomad) {
    val typography = MaterialTheme.typography
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = cafeNomad.name, style = typography.bodyLarge)
            Box(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "咖啡:${cafeNomad.tasty}★",
                    style = typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "價格:${cafeNomad.cheap}★",
                    style = typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "安靜:${cafeNomad.quiet}★",
                    style = typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "音樂:${cafeNomad.music}★",
                    style = typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
            }
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Wi-Fi:${cafeNomad.wifi}★",
                    style = typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    text = "座位:${cafeNomad.seat}★",
                    style = typography.bodyMedium,
                    modifier = Modifier.weight(1f)
                )
            }
            Divider(
                color = Color.Gray,
                thickness = 1.dp,
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(text = cafeNomad.address, style = typography.bodyMedium)
        }
    }
}