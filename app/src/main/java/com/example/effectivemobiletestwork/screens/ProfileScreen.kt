package com.example.effectivemobiletestwork.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.bottom_navigation.BottomNavigationRoute
import com.example.effectivemobiletestwork.common.EnterButton
import com.example.effectivemobiletestwork.common.ProfileCardItem
import com.example.effectivemobiletestwork.common.ProfileInfoCard
import com.example.effectivemobiletestwork.navigation.NavigationRoute
import com.example.effectivemobiletestwork.ui.theme.Gray
import com.example.effectivemobiletestwork.ui.theme.Orange
import com.example.effectivemobiletestwork.ui.theme.Pink
import com.example.effectivemobiletestwork.ui.theme.SoftGray

data class ProfileInfoItems(val icon: Int, val title: String, val colorIcon: Color, val buttonNav: String)

@Composable
fun ProfileScreen(
    navController: NavController
) {
    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )
    val profile_items = listOf(
        ProfileInfoItems(icon = R.drawable.heart_icon, title = "Избранное", colorIcon = Pink, buttonNav = BottomNavigationRoute.FavoriteScreen.route),
        ProfileInfoItems(icon = R.drawable.markets_icon, title = "Магазины", colorIcon = Pink, buttonNav = BottomNavigationRoute.FavoriteScreen.route),
        ProfileInfoItems(icon = R.drawable.message_icon, title = "Обратная связь", colorIcon = Orange, buttonNav = BottomNavigationRoute.FavoriteScreen.route),
        ProfileInfoItems(icon = R.drawable.offer_icon, title = "Оферта", colorIcon = SoftGray, buttonNav = BottomNavigationRoute.FavoriteScreen.route),
        ProfileInfoItems(icon = R.drawable.back_commodity_icon, title = "Возврат товара", colorIcon = SoftGray, buttonNav = BottomNavigationRoute.FavoriteScreen.route)
    )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp, bottom = 10.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Личный кабинет",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_regular
                ),
                textAlign = TextAlign.Center
            )
        }
        Box(
            modifier = Modifier.padding(top = 24.dp)
        ) {
            ProfileInfoCard()
        }
        Column(
            modifier = Modifier.padding(top = 16.dp)
        ) {
            profile_items.forEach{item ->
                ProfileCardItem(navController = navController, item = item)
            }
        }
        Box(
            modifier = Modifier.fillMaxHeight().padding(bottom = 80.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            EnterButton(
                navController = navController,
                navigationRoute = NavigationRoute.RegistrationScreen.route,
                "Выйти",
                colorButton = Gray,
                colorText = Color.Black
            )
        }
    }
}