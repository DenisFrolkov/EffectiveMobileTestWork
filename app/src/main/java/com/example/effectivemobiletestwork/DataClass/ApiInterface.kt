package com.example.effectivemobiletestwork.DataClass

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("97e721a7-0a66-4cae-b445-83cc0bcf9010")
    suspend fun getData(): MyData
}

