package com.kitwtnb.droidkaigi2018contributors

import android.app.Application
import com.kitwtnb.droidkaigi2018contributors.di.getModule
import com.kitwtnb.droidkaigi2018contributors.di.jsonMapperModule
import com.squareup.leakcanary.LeakCanary
import org.koin.android.ext.android.startKoin
import timber.log.Timber
import org.koin.dsl.module.applicationContext as appContext

class App: Application() {
    override fun onCreate() {
        super.onCreate()

        if (LeakCanary.isInAnalyzerProcess(this)) {
            return
        }
        LeakCanary.install(this)
        Timber.plant(Timber.DebugTree())
        startKoin(this, listOf(getModule(this), jsonMapperModule))
    }
}
