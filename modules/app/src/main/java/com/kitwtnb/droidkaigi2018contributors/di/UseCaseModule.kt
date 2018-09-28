package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.usecase.DeleteCacheUseCase
import com.kitwtnb.droidkaigi2018contributors.usecase.DeleteCacheUseCaseImpl
import com.kitwtnb.droidkaigi2018contributors.usecase.ShowContributorsUseCase
import com.kitwtnb.droidkaigi2018contributors.usecase.ShowContributorsUseCaseImpl
import org.koin.dsl.module.module
import org.koin.experimental.builder.singleBy

val useCaseModule = module {
    singleBy<ShowContributorsUseCase, ShowContributorsUseCaseImpl>()
    singleBy<DeleteCacheUseCase, DeleteCacheUseCaseImpl>()
}
