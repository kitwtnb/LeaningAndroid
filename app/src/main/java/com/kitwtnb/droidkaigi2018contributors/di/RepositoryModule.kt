package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.repository.GithubRepository
import com.kitwtnb.droidkaigi2018contributors.repository.GithubRepositoryImpl
import org.koin.dsl.module.module

val repositoryModule = module {
    single<GithubRepository> { GithubRepositoryImpl(get(), get()) }
}
