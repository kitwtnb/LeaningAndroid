package com.kitwtnb.droidkaigi2018contributors

import io.reactivex.Single
import retrofit2.http.GET

interface ApiService {
    @get:GET("api")
    val randomUser: Single<RandomUser>
}
