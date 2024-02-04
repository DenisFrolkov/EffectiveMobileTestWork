package com.example.effectivemobiletestwork.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.effectivemobiletestwork.R
import com.example.effectivemobiletestwork.common.EnterButton
import com.example.effectivemobiletestwork.common.TextInput
import com.example.effectivemobiletestwork.navigation.NavigationRoute
import com.example.effectivemobiletestwork.ui.theme.LightPink
import com.example.effectivemobiletestwork.ui.theme.Pink

@Composable
fun RegistrationScreen(
    navController: NavController
) {

    val sfprodisplay_regular = FontFamily(
        Font(R.font.sfprodisplay_regular, FontWeight.Normal),
    )

    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = "Войти",
                style = TextStyle(
                    fontSize = 16.sp,
                    color = Color.Black,
                    fontFamily = sfprodisplay_regular
                ),
                textAlign = TextAlign.Center
            )
        }
        Column(
            modifier = Modifier.padding(top = 139.dp)
        ) {
            TextInput(
                inputText = "Имя",
                onTextChanged = { newName -> name = newName },
                validation = { text -> text.matches(Regex("^[А-Яа-я]*\$")) }
            )

            TextInput(
                inputText = "Фамилия",
                onTextChanged = { newSurname -> surname = newSurname }, // Исправлено
                validation = { text -> text.matches(Regex("^[А-Яа-я]*\$")) }
            )

            TextInput(
                inputText = "Номер телефона",
                onTextChanged = { newPhoneNumber -> phoneNumber = newPhoneNumber },
                validation = { text -> text.matches(Regex("^(\\+7 |7 )?\\d{3} \\d{3}-\\d{2}-\\d{2}\$")) }
            )
        }
        Box(
            modifier = Modifier.padding(top = 32.dp)
        ) {
            EnterButton(
                navController = navController,
                navigationRoute = if (name.isNotEmpty() && surname.isNotEmpty() && phoneNumber.isNotEmpty()) NavigationRoute.BottomNavigation.route else "",
                "Войти",
                colorButton = if (name.isNotEmpty() && surname.isNotEmpty() && phoneNumber.isNotEmpty()) Pink else LightPink,
                colorText = Color.White
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 11.dp),
            contentAlignment = Alignment.BottomCenter
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth(),
                text = buildAnnotatedString {
                    append("Нажимая кнопку “Войти”, Вы принимаете\n")
                    withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                        append("условия программы лояльности")
                    }
                },
                style = TextStyle(
                    fontSize = 10.sp,
                    color = Color.Gray
                ),
                textAlign = TextAlign.Center
            )
        }
    }
}