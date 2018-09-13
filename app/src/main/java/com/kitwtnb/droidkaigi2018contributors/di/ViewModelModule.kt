package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.view.contributors.ContributorsViewModel
import com.kitwtnb.droidkaigi2018contributors.view.main.MainViewModel
import kotlinx.coroutines.experimental.android.UI
import org.koin.android.architecture.ext.viewModel
import org.koin.dsl.module.applicationContext

val viewModelModule = applicationContext {
    viewModel { MainViewModel(get()) }
    viewModel { ContributorsViewModel(UI, get()) }
}
