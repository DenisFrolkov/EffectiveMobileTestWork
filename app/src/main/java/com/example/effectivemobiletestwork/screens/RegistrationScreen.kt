package com.example.effectivemobiletestwork.screens

import androidx.compose.foundation.background
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
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
fun RegistrationScreen(navController: NavController) {
    val sfprodisplay_regular = FontFamily(Font(R.font.sfprodisplay_regular, FontWeight.Normal))
    var name by remember { mutableStateOf("") }
    var surname by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    val stringResource = LocalContext.current.resources

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = Color.White)
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource.getString(R.string.header_login_screen),
            style = TextStyle(
                fontSize = 16.sp,
                color = Color.Black,
                fontFamily = sfprodisplay_regular,
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 15.dp),
        )

        Spacer(modifier = Modifier.height(139.dp))

        TextInput(
            inputText = stringResource.getString(R.string.first_name),
            onTextChanged = { newName -> name = newName },
            validation = { text -> text.matches(Regex("^[А-Яа-я]*$")) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextInput(
            inputText = stringResource.getString(R.string.last_name),
            onTextChanged = { newSurname -> surname = newSurname },
            validation = { text -> text.matches(Regex("^[А-Яа-я]*$")) }
        )

        Spacer(modifier = Modifier.height(10.dp))

        TextInput(
            inputText = stringResource.getString(R.string.phone_number),
            onTextChanged = { newPhoneNumber -> phoneNumber = newPhoneNumber },
            validation = { text ->
                text.matches(Regex("^(\\+7 |\\+7|7 |7)?\\d{3}( |)?\\d{3}(-| |)?\\d{2}(-| |)?\\d{2}$"))
            }
        )

        Spacer(modifier = Modifier.height(32.dp))

        EnterButton(
            navController = navController,
            navigationRoute = if (name.isNotEmpty() && surname.isNotEmpty() && phoneNumber.isNotEmpty())
                NavigationRoute.BottomNavigation.route
            else "",
            textButton = stringResource.getString(R.string.header_login_screen),
            colorButton = if (name.isNotEmpty() && surname.isNotEmpty() && phoneNumber.isNotEmpty()) Pink else LightPink,
            colorText = Color.White
        )

        Spacer(
            modifier = Modifier
                .fillMaxHeight()
                .padding(bottom = 11.dp)
        )

        Text(
            text = buildAnnotatedString {
                append(stringResource.getString(R.string.terms_and_conditions))
                withStyle(style = SpanStyle(textDecoration = TextDecoration.Underline)) {
                    append(stringResource.getString(R.string.loyalty_program_terms))
                }
            },
            style = TextStyle(
                fontSize = 10.sp,
                color = Color.Gray,
                textAlign = TextAlign.Center
                ),
            modifier = Modifier.fillMaxWidth(),
        )
    }
}
