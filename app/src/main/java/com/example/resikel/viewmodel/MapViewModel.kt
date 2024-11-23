package com.example.resikel.viewmodel

import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.os.Build
import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.maps.model.LatLng
import java.io.IOException
import java.util.Locale

class MapViewModel : ViewModel() {
    //getting user location
    private val _userLocation = mutableStateOf<LatLng?>(null)
    val userLocation: State<LatLng?> = _userLocation

    private val _userAddress = mutableStateOf("")
    val userAddress = _userAddress


    fun fetchUserLocation(context: Context, fusedLocationClient: FusedLocationProviderClient) {
        //check if permission is granted
        if (ContextCompat.checkSelfPermission(
                context,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            try {
                //get last location
                fusedLocationClient.lastLocation.addOnSuccessListener { location ->
                    location?.let {
                        val userLatLng = LatLng(it.latitude, it.longitude)
                        _userLocation.value = userLatLng
                    }
                }
            } catch (e: SecurityException) {
                Log.e("MapViewModel", "Permission revoked: ${e.message}")
            }
        } else {
            Log.e("MapViewModel", "Permission denied")
        }
    }

    fun getMarkerAddress(lat: Double, lng: Double, context: Context) {
        val geocoder = Geocoder(context, Locale.getDefault())
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                geocoder.getFromLocation(lat, lng, 1, object : Geocoder.GeocodeListener {
                    override fun onGeocode(addresses: MutableList<Address>) {
                        if (addresses.isNotEmpty()) {
                            val address = addresses[0].getAddressLine(0)
                            _userAddress.value = address
                        }
                    }
                })
            } else {
                val addresses = geocoder.getFromLocation(lat, lng, 1)
                if (addresses!!.isNotEmpty()) {
                    val address = addresses[0].getAddressLine(0)
                    _userAddress.value = address
                } else {
                    Log.e("MapViewModel", "Error Getting Address")
                }
            }
        } catch (e: IOException) {
            Log.e("MapScreen", "Error: ${e.message}")
        }
    }
}