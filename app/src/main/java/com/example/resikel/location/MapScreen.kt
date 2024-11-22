package com.example.resikel.location

import android.content.pm.PackageManager
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.resikel.report.SummaryReport
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.ui.theme.primaryGreen
import com.example.resikel.ui.theme.primaryWhite
import com.example.resikel.viewmodel.MapViewModel
import com.google.android.gms.location.LocationServices
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.MarkerComposable
import com.google.maps.android.compose.MarkerState
import com.google.maps.android.compose.rememberCameraPositionState

//TODO: GET DATA FROM API & IMPLEMENT CURRENT LOCATION N SET POLYLINE TO DESINATION ROUTE
@Composable
fun MapScreen(mapViewModel: MapViewModel) {
    val location = LatLng(40.9971, 29.1007)
    val location2 = LatLng(40.9867, 29.0570)
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
    Column() {
        //Google Map Section
        GoogleMap(
            modifier = Modifier
                .fillMaxWidth()
                .weight(3f),
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
            //TODO: TESTING GET LOCATION
            userLocation?.let {
                Marker(
                    state = MarkerState(position = it),
                    title = "Your Location",
                    snippet = "Current Location Snippet"
                )
                cameraPositionState.position = CameraPosition.fromLatLngZoom(it, 10f)
            }
        }
        //Route Section
        Column(modifier = Modifier.weight(1f)) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .background(color = primaryGreen)
                    .padding(14.dp)
            ) {
                Text(
                    text = "Maps",
                    fontWeight = FontWeight.Bold,
                    color = primaryWhite,
                    fontSize = 18.sp
                )
            }
            Column(
                modifier = Modifier
                    .clip(
                        RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp)
                    )
                    .background(color = primaryWhite)
                    .padding(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Your route", fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
                //TODO: CLICK DI SINI UNTUK MENDAPATKAN CURRENT LOCATION or Click di Icon Map
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(
                        imageVector = Icons.Default.Home,
                        contentDescription = null
                    )
                    Text(text = "Jl. Budi Mulia Gang Kelinci RT 001 RW 002 Batam")
                }
                HorizontalDivider()
                //TODO: CLICK DI MARKER MAP UNTUK MENDAPATKAN LOKASI DESTINATION
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(
                        imageVector = Icons.Default.LocationOn,
                        contentDescription = null
                    )
                    Text(text = "Destination Route")
                }
                HorizontalDivider()
            }
        }

    }
}

/*
@Preview(showBackground = true)
@Composable
private fun MapScreenPreview() {
    ResikelTheme {
        MapScreen()
    }
}*/
