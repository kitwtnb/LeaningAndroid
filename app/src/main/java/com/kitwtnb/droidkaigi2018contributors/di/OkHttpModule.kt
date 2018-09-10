package com.kitwtnb.droidkaigi2018contributors.di

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.applicationContext
import timber.log.Timber
import java.util.concurrent.TimeUnit

val okHttpModule = applicationContext {
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
}
