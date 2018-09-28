package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.datastore.db.AppDataBase
import com.kitwtnb.droidkaigi2018contributors.datastore.db.ContributorDao
import org.koin.dsl.module.module

val daoModule = module {
    single<ContributorDao> {
        (get() as AppDataBase).contributorDao()
    }
}
