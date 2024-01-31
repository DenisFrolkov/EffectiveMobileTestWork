package com.example.effectivemobiletestwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.effectivemobiletestwork.navigation.Navigation
import com.example.effectivemobiletestwork.ui.theme.EffectiveMobileTestWorkTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EffectiveMobileTestWorkTheme {
                Navigation()
            }
        }
    }
}
