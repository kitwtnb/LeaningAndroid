package com.kitwtnb.droidkaigi2018contributors.di

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.kitwtnb.droidkaigi2018contributors.service.GithubService
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

val githubModule = applicationContext {
    provide<Retrofit> {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("https://api.github.com/")
                .client(get())
                .build()
    }
    provide<GithubService> { (get() as Retrofit).create(GithubService::class.java) }
}
