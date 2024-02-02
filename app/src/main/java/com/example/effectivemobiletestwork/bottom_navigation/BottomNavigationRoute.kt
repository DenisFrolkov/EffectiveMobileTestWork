package com.example.effectivemobiletestwork.bottom_navigation

import com.example.effectivemobiletestwork.R

sealed class BottomNavigationRoute(val route: String) {
    object MainScreen : BottomNavigationRoute("main_screen")
    object CatalogScreen : BottomNavigationRoute("catalog_screen")
    object CartScreen : BottomNavigationRoute("cart_screen")
    object StocksScreen : BottomNavigationRoute("stocks_screen")
    object ProfileScreen : BottomNavigationRoute("profile_screen")
}