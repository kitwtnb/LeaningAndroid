package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.usecase.DeleteCacheUseCase
import com.kitwtnb.droidkaigi2018contributors.usecase.DeleteCacheUseCaseImpl
import com.kitwtnb.droidkaigi2018contributors.usecase.ShowContributorsUseCase
import com.kitwtnb.droidkaigi2018contributors.usecase.ShowContributorsUseCaseImpl
import org.koin.dsl.module.applicationContext

val useCaseModule = applicationContext {
    provide<ShowContributorsUseCase> { ShowContributorsUseCaseImpl(get()) }
    provide<DeleteCacheUseCase> { DeleteCacheUseCaseImpl(get()) }
}
