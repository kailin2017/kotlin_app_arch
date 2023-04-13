package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.navigation.NavHostController
import tw.idv.kailin.kotlin.cafe.model.CafeNomad

@Composable
fun HomeListScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HomeListViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    Column(modifier = modifier.fillMaxSize()) {
        CafeFilter(selectedCities = uiState.selectedCities) {
            viewModel.dialogExpanded(true)
        }
        CafeList(cafes = uiState.cafes)
    }
    if (uiState.dialogExpanded) {
        FilterDialog(
            modifier = Modifier,
            cities = uiState.cities,
            selectCities = uiState.selectedCities,
            onCheckedChange = { city, selected ->
                viewModel.setSelectCity(city, selected)
            },
            onDismissRequest = { viewModel.dialogExpanded(false) }
        )
    }
}

@Composable
fun FilterDialog(
    modifier: Modifier = Modifier,
    cities: List<String> = listOf(),
    selectCities: List<String> = listOf(),
    onCheckedChange: (String, Boolean) -> Unit,
    onDismissRequest: () -> Unit
) {
    Dialog(onDismissRequest = onDismissRequest) {
        Column(
            modifier = modifier
                .background(Color.White, RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.95f)
                .padding(8.dp)
        ) {
            FilterDialogList(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f),
                cities = cities,
                selectCities = selectCities,
                onCheckedChange = onCheckedChange
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    onClick = onDismissRequest
                ) {
                    Text("Confirm")
                }
            }
        }
    }

}

@Composable
fun FilterDialogList(
    modifier: Modifier = Modifier,
    cities: List<String> = listOf(),
    selectCities: List<String> = listOf(),
    onCheckedChange: (String, Boolean) -> Unit,
) {
    val typography = MaterialTheme.typography
    LazyColumn(modifier = modifier) {
        items(cities) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Checkbox(
                        modifier = Modifier
                            .padding(8.dp)
                            .size(16.dp),
                        checked = selectCities.contains(it),
                        onCheckedChange = { checked ->
                            onCheckedChange(it, checked)
                        }
                    )
                    Text(text = it, style = typography.bodyMedium)
                }
            }
        }
    }
}

@Composable
fun CafeFilter(
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
fun CafeList(cafes: List<CafeNomad> = listOf()) {
    val typography = MaterialTheme.typography
    LazyColumn(modifier = Modifier.fillMaxWidth()) {
        items(cafes) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = it.name, style = typography.bodyLarge)
                    Box(modifier = Modifier.height(8.dp))
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "咖啡:${it.tasty}★",
                            style = typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "價格:${it.cheap}★",
                            style = typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "安靜:${it.quiet}★",
                            style = typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "音樂:${it.music}★",
                            style = typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Wi-Fi:${it.wifi}★",
                            style = typography.bodyMedium,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "座位:${it.seat}★",
                            style = typography.bodyMedium,
                            modifier = Modifier.weight(1f)
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