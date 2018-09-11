package com.kitwtnb.droidkaigi2018contributors.repository

import com.kitwtnb.droidkaigi2018contributors.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.service.GithubService
import kotlinx.coroutines.experimental.Deferred

interface GithubRepository {
    fun loadContributors(owner: String, repository: String): Deferred<List<Contributor>>
}

class GithubRepositoryImpl(private val service: GithubService) : GithubRepository {
    override fun loadContributors(owner: String, repository: String) = service.contributors(owner, repository)
}
