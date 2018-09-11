package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.repository.GithubRepository
import com.kitwtnb.droidkaigi2018contributors.repository.GithubRepositoryImpl
import org.koin.dsl.module.applicationContext

val repositoryModule = applicationContext {
    provide<GithubRepository> { GithubRepositoryImpl(get()) }
}
