package com.example.effectivemobiletestwork.bottom_navigation

import com.example.effectivemobiletestwork.R

sealed class BottomNavItem(val route: String, val icon: Int, val label: String) {
    object Main : BottomNavItem(BottomNavigationRoute.MainScreen.route, R.drawable.main_icon,"Главная")
    object Catalog : BottomNavItem(BottomNavigationRoute.CatalogScreen.route, R.drawable.catalog_icon, "Каталог")
    object Cart : BottomNavItem(BottomNavigationRoute.CartScreen.route, R.drawable.card_icon, "Корзина")
    object Stocks : BottomNavItem(BottomNavigationRoute.StocksScreen.route, R.drawable.stocks_icon, "Акции")
    object Profile : BottomNavItem(BottomNavigationRoute.ProfileScreen.route, R.drawable.profile_icon, "Профиль")
}