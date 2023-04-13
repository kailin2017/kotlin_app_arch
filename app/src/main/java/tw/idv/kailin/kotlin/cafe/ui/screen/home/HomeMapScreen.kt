package tw.idv.kailin.kotlin.cafe.ui.screen.home

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun HomeMapScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    val taipei = LatLng(25.0418631,121.5463536)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(taipei, 12f)
    }
    GoogleMap(
        modifier = Modifier.fillMaxSize(),
        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = MarkerState(position = taipei),
            title = "Singapore",
            snippet = "Marker in Singapore"
        )
    }
}