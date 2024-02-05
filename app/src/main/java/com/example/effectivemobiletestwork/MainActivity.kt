package com.example.effectivemobiletestwork

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import com.example.effectivemobiletestwork.DataClass.ApiInterface
import com.example.effectivemobiletestwork.DataClass.Item
import com.example.effectivemobiletestwork.DataClass.MyData
import com.example.effectivemobiletestwork.navigation.Navigation
import com.example.effectivemobiletestwork.ui.theme.EffectiveMobileTestWorkTheme
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://run.mocky.io/v3/"


class MainActivity : ComponentActivity() {

    private var items by mutableStateOf<List<Item>>(emptyList())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LaunchedEffect(Unit) {
                fetchData()
            }

            EffectiveMobileTestWorkTheme {
                Navigation(items = items)
            }
        }
    }

    private suspend fun fetchData() {
        val service = createApiService()

        try {
            val data = withContext(Dispatchers.IO) {
                service.getData()
            }
            items = data.items
        } catch (e: Exception) {
            // Обработка ошибки
            e.printStackTrace()
        }
    }

    private fun createApiService(): ApiInterface {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(Gson()))
            .build()
            .create(ApiInterface::class.java)
    }
}