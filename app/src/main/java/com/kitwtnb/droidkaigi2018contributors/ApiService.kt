package com.kitwtnb.droidkaigi2018contributors

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @get:GET("api")
    val randomUser: Call<RandomUser>
}
