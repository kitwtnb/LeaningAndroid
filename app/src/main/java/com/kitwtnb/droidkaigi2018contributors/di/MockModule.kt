package com.kitwtnb.droidkaigi2018contributors.di

import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.datastore.data.ContributorEntity
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Info
import com.kitwtnb.droidkaigi2018contributors.datastore.data.RandomUser
import com.kitwtnb.droidkaigi2018contributors.datastore.db.ContributorDao
import com.kitwtnb.droidkaigi2018contributors.datastore.service.ApiService
import com.kitwtnb.droidkaigi2018contributors.datastore.service.GithubService
import kotlinx.coroutines.experimental.Deferred
import org.koin.dsl.module.applicationContext
import retrofit2.mock.MockRetrofit
import retrofit2.mock.NetworkBehavior
import java.util.concurrent.TimeUnit

val mockModule = applicationContext {
    provide<NetworkBehavior> {
        NetworkBehavior.create().also {
            it.setDelay(100, TimeUnit.MILLISECONDS)
            it.setFailurePercent(0)
            it.setErrorPercent(0)
        }
    }

    provide<MockRetrofit> {
        MockRetrofit.Builder(get(DataStoreModule.PROVIDE_FOR_GITHUB))
                .networkBehavior(get())
                .build()
    }

    provide<GithubService> {
        val delegate = (get() as MockRetrofit).create(GithubService::class.java)

        object : GithubService {
            override fun contributors(owner: String, repository: String): Deferred<List<Contributor>> {
                return delegate.returningResponse(listOf<Contributor>()).contributors(owner, repository)
            }
        }
    }

    provide<ApiService> {
        val delegate = (get() as MockRetrofit).create(ApiService::class.java)

        object : ApiService {
            override val randomUser: Deferred<RandomUser> = delegate.returningResponse(RandomUser(Info("", 0, 0, ""), listOf())).randomUser
        }
    }

    provide<ContributorDao> {
        object : ContributorDao {
            override fun fetchBy(owner: String, repository: String): List<ContributorEntity> = listOf()
            override fun insert(contributors: List<ContributorEntity>) { }
            override fun delete() { }
            override fun deleteBy(owner: String, repository: String) { }
        }
    }
}
