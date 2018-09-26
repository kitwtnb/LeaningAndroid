package com.kitwtnb.droidkaigi2018contributors.di

import android.arch.persistence.room.Room
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.kitwtnb.droidkaigi2018contributors.datastore.db.AppDataBase
import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import timber.log.Timber
import java.util.concurrent.TimeUnit

object DataStoreModule {
    const val PROVIDE_FOR_GITHUB = "github"
    const val PROVIDE_FOR_RANDOM_USER = "random user"
}

val dataStoreModule = applicationContext {
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

    provide<Retrofit>(DataStoreModule.PROVIDE_FOR_GITHUB) {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("https://api.github.com/")
                .client(get())
                .build()
    }

    provide<Retrofit>(DataStoreModule.PROVIDE_FOR_RANDOM_USER) {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl("http://randomuser.me/")
                .client(get())
                .build()
    }

    provide<AppDataBase> {
        Room.databaseBuilder(androidApplication(), AppDataBase::class.java, "sqlite.db").build()
    }
}
