package com.kitwtnb.droidkaigi2018contributors

import android.app.Application
import org.koin.android.ext.android.startKoin
import org.koin.dsl.module.applicationContext as appContext

class App: Application() {
    private val module = appContext {
        factory<Contributor> { ContributorImpl() }
    }

    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(module))
    }
}
