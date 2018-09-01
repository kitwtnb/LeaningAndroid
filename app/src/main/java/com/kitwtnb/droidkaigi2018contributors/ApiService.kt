package com.kitwtnb.droidkaigi2018contributors

import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface ApiService {
    @get:GET("api")
    val randomUser: Deferred<RandomUser>
}
