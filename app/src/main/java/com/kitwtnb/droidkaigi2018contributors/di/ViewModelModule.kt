package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.view.contributors.ContributorsViewModel
import com.kitwtnb.droidkaigi2018contributors.view.main.MainViewModel
import kotlinx.coroutines.experimental.android.UI
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModelModule = module {
    viewModel { MainViewModel(get(), get()) }
    viewModel { ContributorsViewModel(UI, get()) }
}
