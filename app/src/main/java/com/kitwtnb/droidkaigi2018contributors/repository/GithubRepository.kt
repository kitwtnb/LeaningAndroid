package com.kitwtnb.droidkaigi2018contributors.repository

import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.datastore.db.ContributorDao
import com.kitwtnb.droidkaigi2018contributors.datastore.db.deferredDelete
import com.kitwtnb.droidkaigi2018contributors.datastore.db.deferredFetchBy
import com.kitwtnb.droidkaigi2018contributors.datastore.db.deferredReplace
import com.kitwtnb.droidkaigi2018contributors.datastore.service.GithubService
import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.experimental.async

interface GithubRepository {
    suspend fun loadContributors(owner: String, repository: String): Deferred<List<Contributor>>
    suspend fun refreshContributors(owner: String, repository: String): Deferred<List<Contributor>>
    suspend fun deleteContributors(): Deferred<Unit>
}

class GithubRepositoryImpl(
        private val service: GithubService,
        private val contributorDao: ContributorDao
) : GithubRepository {
    override suspend fun loadContributors(owner: String, repository: String): Deferred<List<Contributor>> {
        val cache = contributorDao.deferredFetchBy(owner, repository).await()
        if (cache.isNotEmpty()) {
            return async { cache.map { it.contributor } }
        }

        return refreshContributors(owner, repository)
    }

    override suspend fun refreshContributors(owner: String, repository: String): Deferred<List<Contributor>> {
        val contributors = service.contributors(owner, repository).await()
        contributorDao.deferredReplace(owner, repository, contributors).await()

        return async { contributors }
    }

    override suspend fun deleteContributors(): Deferred<Unit> = contributorDao.deferredDelete()
}
