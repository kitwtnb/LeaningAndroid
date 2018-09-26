package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.usecase.DeleteCacheUseCase
import com.kitwtnb.droidkaigi2018contributors.usecase.DeleteCacheUseCaseImpl
import com.kitwtnb.droidkaigi2018contributors.usecase.ShowContributorsUseCase
import com.kitwtnb.droidkaigi2018contributors.usecase.ShowContributorsUseCaseImpl
import org.koin.dsl.module.module

val useCaseModule = module {
    single<ShowContributorsUseCase> { ShowContributorsUseCaseImpl(get()) }
    single<DeleteCacheUseCase> { DeleteCacheUseCaseImpl(get()) }
}
