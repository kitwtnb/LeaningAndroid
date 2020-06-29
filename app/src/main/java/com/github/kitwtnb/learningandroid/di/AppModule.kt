package com.github.kitwtnb.learningandroid.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
class ApplicationModule {
    @Provides
    fun provideHash(): String = hashCode().toString()
}
