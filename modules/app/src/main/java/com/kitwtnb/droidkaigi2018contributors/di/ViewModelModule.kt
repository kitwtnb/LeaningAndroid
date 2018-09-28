package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.view.contributors.ContributorsViewModel
import com.kitwtnb.droidkaigi2018contributors.view.main.MainViewModel
import kotlinx.coroutines.experimental.android.UI
import org.koin.android.viewmodel.experimental.builder.viewModel
import org.koin.dsl.module.module
import kotlin.coroutines.experimental.CoroutineContext

val viewModelModule = module {
    single { UI as CoroutineContext }
    viewModel<MainViewModel>()
    viewModel<ContributorsViewModel>()
}
