package com.kitwtnb.droidkaigi2018contributors.usecase

import com.kitwtnb.droidkaigi2018contributors.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.repository.GithubRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.withContext

interface ShowContributorsUseCase {
    suspend fun showContributors(): List<Contributor>
}

class ShowContributorsUseCaseImpl(private val repository: GithubRepository) : ShowContributorsUseCase {
    override suspend fun showContributors(): List<Contributor> = withContext(CommonPool) {
        repository.loadContributors("kitwtnb", "LearningAndroid").await()
    }
}
