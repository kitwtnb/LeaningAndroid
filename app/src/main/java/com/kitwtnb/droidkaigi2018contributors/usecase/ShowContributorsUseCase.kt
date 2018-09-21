package com.kitwtnb.droidkaigi2018contributors.usecase

import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.repository.GithubRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.withContext

interface ShowContributorsUseCase {
    suspend fun showContributors(): List<Contributor>
    suspend fun refreshContributors(): List<Contributor>
}

class ShowContributorsUseCaseImpl(private val repository: GithubRepository) : ShowContributorsUseCase {
    companion object {
        private const val OWNER = "DroidKaigi"
        private const val REPOSITORY = "conference-app-2018"
    }

    override suspend fun showContributors(): List<Contributor> = withContext(CommonPool) {
        repository.loadContributors(OWNER, REPOSITORY).await()
    }

    override suspend fun refreshContributors(): List<Contributor> = withContext(CommonPool) {
        repository.refreshContributors(OWNER, REPOSITORY).await()
    }
}
