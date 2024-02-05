package com.example.effectivemobiletestwork.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletestwork.DataClass.Item
import com.example.effectivemobiletestwork.bottom_navigation.BottomNavigation
import com.example.effectivemobiletestwork.screens.ProductPageScreen
import com.example.effectivemobiletestwork.screens.RegistrationScreen
import com.google.accompanist.pager.ExperimentalPagerApi

@OptIn(ExperimentalPagerApi::class)
@Composable
fun Navigation(
    items: List<Item>
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = NavigationRoute.BottomNavigation.route) {
        composable(NavigationRoute.RegistrationScreen.route){
            RegistrationScreen(navController = navController)
        }
        composable(NavigationRoute.BottomNavigation.route){
            BottomNavigation(navController = navController, items = items)
        }
        composable(NavigationRoute.ProductPageScreen.route + "/{itemId}") {
            ProductPageScreen(navController = navController, items = items)
        }
    }
}