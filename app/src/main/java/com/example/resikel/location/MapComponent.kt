package com.example.resikel.location

import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.example.resikel.viewmodel.MapViewModel
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

@Composable
fun MapComponent(mapViewModel: MapViewModel) {
    //dummy location
    val location = LatLng(40.9971, 29.1007)
    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(location, 15f)
    }

    //get current location
    val context = LocalContext.current
    val userLocation by mapViewModel.userLocation
    val fusedLocationClient = remember { LocationServices.getFusedLocationProviderClient(context) }

    //handle permission
    val permissionLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission()
    ) { isGranted ->
        if (isGranted) {
            mapViewModel.fetchUserLocation(context, fusedLocationClient)
        } else {
            Log.e("Map Screen", "Permission denied")
        }
    }

    //Request location permission when composable is launched
    LaunchedEffect(Unit) {
        when (PackageManager.PERMISSION_GRANTED) {
            ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) -> {
                mapViewModel.fetchUserLocation(context, fusedLocationClient)
            }

            else -> {
                permissionLauncher.launch(android.Manifest.permission.ACCESS_FINE_LOCATION)

            }
        }
    }

    GoogleMap(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        cameraPositionState = cameraPositionState
    ) {
        //TODO: Tambahkan beberapa marker disini
        /*Marker(
            state = MarkerState(position = location),
            title = "Contoh Lokasi TPS 1"
        )
        Marker(
            state = MarkerState(position = location2),
            title = "Contoh Lokasi TPS 2"
        )*/
        //TODO: Nanti untuk custom Marker / Pembeda Tiap TPS
        /*MarkerComposable(state = MarkerState(position = location)) {
            Image(
                painter = painterResource(),
                contentDescription = null,
            )
        }*/
        //TODO: KETIKA USER KLIK MAP OTOMATIS KE CURRENT LOCATION
        userLocation?.let {
            Marker(
                state = MarkerState(position = it),
                title = "Your Location",
                snippet = "Current Location Snippet"
            )
            cameraPositionState.position = CameraPosition.fromLatLngZoom(it, 10f)
        }
    }
}