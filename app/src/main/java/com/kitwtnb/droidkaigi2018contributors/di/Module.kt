package com.kitwtnb.droidkaigi2018contributors.di

import android.content.Context
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.experimental.CoroutineCallAdapterFactory
import com.kitwtnb.droidkaigi2018contributors.ApiService
import com.kitwtnb.droidkaigi2018contributors.ApplicationJsonAdapterFactory
import com.kitwtnb.droidkaigi2018contributors.R
import com.kitwtnb.droidkaigi2018contributors.MainViewModel
import com.squareup.moshi.Moshi
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

fun getModule(context: Context) = applicationContext {
    viewModel { MainViewModel(get()) }

    /**
     * Network
     */
    provide<Moshi> {
        Moshi.Builder()
             .add(ApplicationJsonAdapterFactory)
             .build()
    }

    provide<Retrofit> {
        Retrofit.Builder()
                .addConverterFactory(MoshiConverterFactory.create(get()))
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .baseUrl(context.getString(R.string.service_url))
                .client(get())
                .build()
    }
    provide<ApiService> { (get() as Retrofit).create(ApiService::class.java) }
}
