package tw.idv.kailin.kotlin.cafe.ui.screen.home.dialog

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun FilterDialogScreen(
    cities: List<String> = listOf(),
    defaultSelect: List<String> = listOf(),
    onDismiss: () -> Unit,
    onConfirm: (List<String>) -> Unit,
) {
    val typography = MaterialTheme.typography
    val selectCities = remember { mutableStateListOf<String>() }.apply {
        addAll(defaultSelect)
    }
    Dialog(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(16.dp))
                .fillMaxWidth()
                .fillMaxHeight(0.95f)
                .padding(8.dp)
        ) {
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
                        onConfirm(selectCities.toList())
                    }
                ) {
                    Text("Confirm")
                }
            }
        }
    }
}
