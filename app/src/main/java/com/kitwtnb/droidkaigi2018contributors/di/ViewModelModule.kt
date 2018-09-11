package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.MainViewModel
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val viewModelModule = applicationContext {
    viewModel { MainViewModel(get()) }
}
