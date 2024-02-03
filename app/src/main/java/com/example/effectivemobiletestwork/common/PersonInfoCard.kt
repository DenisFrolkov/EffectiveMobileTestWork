package com.example.effectivemobiletestwork.common

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.effectivemobiletestwork.ui.theme.Gray
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.ui.theme.Dark
import com.example.effectivemobiletestwork.ui.theme.SoftGray

@Composable
fun ProfileInfoCard() {
    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(color = Gray, shape = RoundedCornerShape(size = 8.dp))
            .height(height = 49.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            Icon(
                modifier = Modifier.padding(vertical = 12.dp, horizontal = 8.dp),
                painter = painterResource(id = R.drawable.profile_icon),
                contentDescription = null
            )
        }
        Column(
            modifier = Modifier.padding(start = 16.dp),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Марина Иванова",
                style = TextStyle(
                    fontSize = 14.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_regular
                )
            )
            Spacer(modifier = Modifier.height(height = 6.dp))
            Text(
                text = "+ 7 993 877 44 02",
                style = TextStyle(
                    fontSize = 10.sp,
                    color = SoftGray,
                    fontFamily = sfprodisplay_regular
                )
            )
        }
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.CenterEnd
        ) {
            Icon(
                modifier = Modifier.padding(all = 8.dp),
                painter = painterResource(id = R.drawable.exit_icon),
                contentDescription = null
            )
        }
    }
}