package com.kitwtnb.droidkaigi2018contributors.di

import android.content.Context
import com.kitwtnb.droidkaigi2018contributors.ApiService
import com.kitwtnb.droidkaigi2018contributors.Contributor
import com.kitwtnb.droidkaigi2018contributors.ContributorImpl
import com.kitwtnb.droidkaigi2018contributors.R
import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

fun getModule(context: Context) = applicationContext {
    factory<Contributor> { ContributorImpl() }

    /**
     * Network
     */
    provide<Moshi> {
        Moshi.Builder()
             .add(KotlinJsonAdapterFactory())
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
    provide<Retrofit> {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .baseUrl(context.getString(R.string.service_url))
                .client(get())
                .build()
    }
    provide<ApiService> { (get() as Retrofit).create(ApiService::class.java) }
}
