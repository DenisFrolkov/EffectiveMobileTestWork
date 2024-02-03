package com.example.effectivemobiletestwork.navigation

sealed class NavigationRoute(val route: String) {
    object RegistrationScreen : NavigationRoute("registration_screen")
    object CatalogScreen : NavigationRoute("catalog_screen")
    object BottomNavigation : NavigationRoute("bottom_navigation")
    object ProductPageScreen : NavigationRoute("product_page_screen")
}