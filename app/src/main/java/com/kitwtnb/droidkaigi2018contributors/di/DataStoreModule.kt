package com.kitwtnb.droidkaigi2018contributors.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.kitwtnb.droidkaigi2018contributors.datastore.service.ApiService
import com.kitwtnb.droidkaigi2018contributors.datastore.service.GithubService
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

val dataStoreModule = applicationContext {
    val provideForGithub = "github"
    val provideForRandomUser = "random user"

    provide<Moshi> {
        Moshi.Builder()
                .add(ApplicationJsonAdapterFactory)
                .build()
    }

    provide<OkHttpClient> {
        val logger = HttpLoggingInterceptor.Logger { Timber.tag("OkHttp").d(it) }
        val interceptor = HttpLoggingInterceptor(logger).apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .readTimeout(30, TimeUnit.SECONDS)
                .build()
    }

    provide<Retrofit>(provideForGithub) {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("https://api.github.com/")
                .client(get())
                .build()
    }

    provide<Retrofit>(provideForRandomUser) {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("http://randomuser.me/")
                .client(get())
                .build()
    }

    provide<GithubService> {
        (get(provideForGithub) as Retrofit).create(GithubService::class.java)
    }

    provide<ApiService> {
        (get(provideForRandomUser) as Retrofit).create(ApiService::class.java)
    }
}
