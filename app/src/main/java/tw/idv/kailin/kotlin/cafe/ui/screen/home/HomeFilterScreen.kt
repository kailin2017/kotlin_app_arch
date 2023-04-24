package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.material3.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun FilterDialogScreen(
    cities: List<String> = listOf(),
    filter: HomeFilterState,
    onDismiss: () -> Unit,
    onConfirm: (HomeFilterState) -> Unit,
) {
    val typography = MaterialTheme.typography
    val selectCities = remember { mutableStateListOf(*filter.cities.toTypedArray()) }
    var tasty by remember { mutableStateOf(filter.tasty) }
    var cheap by remember { mutableStateOf(filter.cheap) }
    var quiet by remember { mutableStateOf(filter.quiet) }
    var music by remember { mutableStateOf(filter.music) }
    var seat by remember { mutableStateOf(filter.seat) }
    var wifi by remember { mutableStateOf(filter.wifi) }

    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.95f)
                .padding(8.dp)
        ) {
            FilterSlider("咖啡", typography, tasty) { tasty = it }
            FilterSlider("價錢", typography, cheap) { cheap = it }
            FilterSlider("安靜", typography, quiet) { quiet = it }
            FilterSlider("音樂", typography, music) { music = it }
            FilterSlider("座位", typography, seat) { seat = it }
            FilterSlider("WiFi", typography, wifi) { wifi = it }
            LazyColumn(
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth()
                    .weight(1f),
            ) {
                items(cities) {
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
                                if (checked) {
                                    selectCities.add(it)
                                } else {
                                    selectCities.remove(it)
                                }
                            }
                        )
                        Text(text = it, style = typography.bodyMedium)
                    }
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                OutlinedButton(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(8.dp),
                    onClick = onDismiss
                ) {
                    Text("Cancel")
                }
                Button(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(8.dp),
                    onClick = {
                        onConfirm(
                            HomeFilterState(
                                tasty = tasty,
                                cheap = cheap,
                                quiet = quiet,
                                music = music,
                                seat = seat,
                                wifi = wifi,
                                cities = selectCities.ifEmpty { cities }
                            )
                        )
                    }
                ) {
                    Text("Confirm")
                }
            }
        }
    }
}

@Composable
fun FilterSlider(
    text: String,
    typography: Typography,
    value: Float,
    onValueChange: (Float) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = typography.bodyMedium
        )
        Slider(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            valueRange = 0.0f..5.0f,
        )
    }
}
