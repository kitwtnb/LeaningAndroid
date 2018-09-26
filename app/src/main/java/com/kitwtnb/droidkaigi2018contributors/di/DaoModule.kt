package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.datastore.db.AppDataBase
import com.kitwtnb.droidkaigi2018contributors.datastore.db.ContributorDao
import org.koin.dsl.module.applicationContext

val daoModule = applicationContext {
    provide<ContributorDao> {
        (get() as AppDataBase).contributorDao()
    }
}
