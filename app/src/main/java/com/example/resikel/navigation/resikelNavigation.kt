package com.example.resikel.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.resikel.auth.signIn
import com.example.resikel.auth.signUp
import com.example.resikel.auth.welcomeResikel
import com.example.resikel.resikelApp

@Composable
fun resikelNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome_resikel") {
        composable("welcome_resikel"){ welcomeResikel(navController) }
        composable(route = "sign_in") { signIn(navController) }
        composable("sign_up"){ signUp() }
        composable("resikel_app"){ resikelApp() }
    }
}