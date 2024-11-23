package com.example.resikel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.resikel.auth.welcomeResikel
import com.example.resikel.community.MyCommunity
import com.example.resikel.location.MapScreen
import com.example.resikel.navigation.resikelNavigation
import com.example.resikel.report.ReportScreen
import com.example.resikel.ui.theme.ResikelTheme
import com.example.resikel.viewmodel.MapViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ResikelTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
//                    resikelNavigation()
//                    ReportScreen()
//                    val mapViewModel = MapViewModel()
//                    MapScreen(mapViewModel)
//                    MyCommunity()
                }
            }
        }
    }
}

