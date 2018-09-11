package com.kitwtnb.droidkaigi2018contributors.datastore.service

import com.kitwtnb.droidkaigi2018contributors.datastore.data.RandomUser
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET

interface ApiService {
    @get:GET("api")
    val randomUser: Deferred<RandomUser>
}
