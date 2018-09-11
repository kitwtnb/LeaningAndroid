package com.kitwtnb.droidkaigi2018contributors.usecase

import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.repository.GithubRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.withContext

interface ShowContributorsUseCase {
    suspend fun showContributors(): List<Contributor>
}

class ShowContributorsUseCaseImpl(private val repository: GithubRepository) : ShowContributorsUseCase {
    override suspend fun showContributors(): List<Contributor> = withContext(CommonPool) {
        repository.loadContributors("DroidKaigi", "conference-app-2018").await()
    }
}
