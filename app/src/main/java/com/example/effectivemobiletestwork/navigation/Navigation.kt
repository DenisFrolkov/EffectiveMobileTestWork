package com.example.effectivemobiletestwork.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletestwork.bottom_navigation.BottomNavigation
import com.example.effectivemobiletestwork.screens.CatalogScreen
import com.example.effectivemobiletestwork.screens.FavoriteScreen
import com.example.effectivemobiletestwork.screens.ProductPageScreen
import com.example.effectivemobiletestwork.screens.RegistrationScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable

fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = NavigationRoute.RegistrationScreen.route) {
        composable(NavigationRoute.RegistrationScreen.route){
            RegistrationScreen(navController = navController)
        }
        composable(NavigationRoute.BottomNavigation.route){
            BottomNavigation(navController = navController)
        }
        composable(NavigationRoute.ProductPageScreen.route){
            ProductPageScreen()
        }
    }
}