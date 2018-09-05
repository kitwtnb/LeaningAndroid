package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.ApplicationJsonAdapterFactory
import com.squareup.moshi.Moshi
import org.koin.dsl.module.applicationContext

val jsonMapperModule = applicationContext {
    provide<Moshi> {
        Moshi.Builder()
                .add(ApplicationJsonAdapterFactory)
                .build()
    }
}
