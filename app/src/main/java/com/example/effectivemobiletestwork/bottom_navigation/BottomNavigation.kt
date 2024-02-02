package com.example.effectivemobiletestwork.bottom_navigation

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemColors
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.screens.CartsScreen
import com.example.effectivemobiletestwork.screens.CatalogScreen
import com.example.effectivemobiletestwork.screens.MainScreen
import com.example.effectivemobiletestwork.screens.ProfileScreen
import com.example.effectivemobiletestwork.screens.StocksScreen
import com.example.effectivemobiletestwork.ui.theme.Dark
import com.example.effectivemobiletestwork.ui.theme.Pink

@Preview
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun BottomNavigation() {
    val bottomNavController = rememberNavController()

    val bottomNavigationItems = listOf(
        BottomNavigationItem(
            route = BottomNavigationRoute.MainScreen.route,
            icon = painterResource(id = R.drawable.main_icon),
            label = "Главная"
        ),
        BottomNavigationItem(
            route = BottomNavigationRoute.CatalogScreen.route,
            icon = painterResource(id = R.drawable.catalog_icon),
            label = "Каталог"
        ),
        BottomNavigationItem(
            route = BottomNavigationRoute.CartScreen.route,
            icon = painterResource(id = R.drawable.card_icon),
            label = "Корзина"
        ),
        BottomNavigationItem(
            route = BottomNavigationRoute.StocksScreen.route,
            icon = painterResource(id = R.drawable.stocks_icon),
            label = "Акции"
        ),
        BottomNavigationItem(
            route = BottomNavigationRoute.ProfileScreen.route,
            icon = painterResource(id = R.drawable.profile_icon),
            label = "Профиль"
        )
    )

    var selectedItemIndex by rememberSaveable { mutableIntStateOf(1) }

    Scaffold(
        bottomBar = {
            NavigationBar() {
                Row(
                    modifier = Modifier.fillMaxWidth().background(Color.White)
                ) {
                    bottomNavigationItems.forEachIndexed { index, item ->
                        NavigationBarItem(
                            selected = selectedItemIndex == index,
                            onClick = {
                                selectedItemIndex = index
                                bottomNavController.navigate(item.route)
                            },
                            colors = NavigationBarItemDefaults.colors(
                                indicatorColor = Color.White,
                            ),
                            label = {
                                Text(
                                    text = item.label,
                                    style = TextStyle(
                                        fontSize = 10.sp,
                                        color = if (index == selectedItemIndex) Pink else Dark
                                    )
                                )
                            },
                            icon = {
                                Icon(
                                    modifier = Modifier.size(30.dp),
                                    painter = item.icon,
                                    contentDescription = null,
                                    tint = if (index == selectedItemIndex) Pink else Dark
                                )
                            }
                        )
                    }
                }
            }
        },
    ) {
        NavHost(
            navController = bottomNavController,
            startDestination = BottomNavigationRoute.CatalogScreen.route
        ) {
            bottomNavigationItems.forEach { item ->
                composable(item.route) {
                    when (item.route) {
                        BottomNavigationRoute.MainScreen.route -> MainScreen()
                        BottomNavigationRoute.CatalogScreen.route -> CatalogScreen()
                        BottomNavigationRoute.CartScreen.route -> CartsScreen()
                        BottomNavigationRoute.StocksScreen.route -> StocksScreen()
                        BottomNavigationRoute.ProfileScreen.route -> ProfileScreen()
                        else -> MainScreen()
                    }
                }
            }
        }
    }
}



//@Composable
//fun BottomNavItem(
//    navBottomController: NavController,
//    item: BottomNavItem
//) {
//    Column(
//        modifier = Modifier.clickable {
//            navBottomController.navigate(item.route)
//        },
//        horizontalAlignment = Alignment.CenterHorizontally,
//        verticalArrangement = Arrangement.Center,
//    ) {
//        Icon(
//            painter = painterResource(id = item.icon),
//            contentDescription = item.label,
//            tint = MaterialTheme.colorScheme.primary
//        )
//        Text(
//            text = item.label,
//            color = MaterialTheme.colorScheme.primary
//        )
//    }
//}

