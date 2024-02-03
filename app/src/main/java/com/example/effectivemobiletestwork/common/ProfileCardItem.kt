package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.bottom_navigation.BottomNavigationRoute
import com.example.effectivemobiletestwork.screens.ProfileInfoItems
import com.example.effectivemobiletestwork.ui.theme.Gray
import com.example.effectivemobiletestwork.ui.theme.SoftGray

@Composable
fun ProfileCardItem(
    navController: NavController,
    item: ProfileInfoItems
) {
    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .background(color = Gray, shape = RoundedCornerShape(size = 8.dp))
            .height(height = 49.dp)
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ) {
                navController.navigate(item.buttonNav)
            },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                modifier = Modifier
                    .padding(vertical = 12.dp, horizontal = 8.dp)
                    .size(24.dp),
                painter = painterResource(id = item.icon),
                contentDescription = null,
                tint = item.colorIcon
            )
        }
        Column(
            modifier = Modifier.padding(start = 16.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(
                text = item.title,
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_regular
                )
            )
            if (item.title == "Избранное") {
                Spacer(modifier = Modifier.height(height = 6.dp))
                Text(
                    text = "1 товар",
                    style = TextStyle(
                        fontSize = 10.sp,
                        color = SoftGray,
                        fontFamily = sfprodisplay_regular
                    )
                )
            }
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                modifier = Modifier.padding(all = 12.dp),
                painter = painterResource(id = R.drawable.arrow_icon),
                contentDescription = null
            )
        }
    }
}
