package com.example.effectivemobiletestwork.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletestwork.screens.CatalogScreen
import com.example.effectivemobiletestwork.screens.RegistrationScreen

@Composable

fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoute.CatalogScreen.route) {
        composable(NavigationRoute.RegistrationScreen.route){
            RegistrationScreen(navController = navController)
        }
        composable(NavigationRoute.CatalogScreen.route){
            CatalogScreen()
        }
    }
}