package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.datastore.service.ApiService
import com.kitwtnb.droidkaigi2018contributors.datastore.service.GithubService
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit

val serviceModule = applicationContext {
    provide<GithubService> {
        (get(DataStoreModule.PROVIDE_FOR_GITHUB) as Retrofit).create(GithubService::class.java)
    }

    provide<ApiService> {
        (get(DataStoreModule.PROVIDE_FOR_RANDOM_USER) as Retrofit).create(ApiService::class.java)
    }
}
