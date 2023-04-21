package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState
import tw.idv.kailin.kotlin.cafe.model.CafeNomad
import tw.idv.kailin.kotlin.cafe.model.RepoStatus

@Composable
fun HomeMapScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    viewModel: HomeViewModel
) {
    val uiState by viewModel.uiState.collectAsState()
    if (uiState.cafeState.status == RepoStatus.Loading){
        CircularProgressIndicator(modifier = modifier)
    } else {
        HomeMapContent(modifier = modifier, list = uiState.cafeState.data ?: listOf())
    }
}

@Composable
fun HomeMapContent(modifier: Modifier = Modifier, list: List<CafeNomad>){
    val cameraPositionState = rememberCameraPositionState {}
    if (list.isNotEmpty()) {
        cameraPositionState.position = CameraPosition.fromLatLngZoom(
            LatLng(list[0].latitude.toDouble(), list[0].longitude.toDouble()), 12f
        )
    }
    GoogleMap(
        modifier = modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        list.take(100).forEach {
            Marker(
                state = MarkerState(
                    position = LatLng(
                        it.latitude.toDouble(),
                        it.longitude.toDouble()
                    )
                ),
                title = it.name,
                snippet = it.address
            )
        }
    }
}