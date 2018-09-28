package com.kitwtnb.droidkaigi2018contributors.usecase

import com.kitwtnb.droidkaigi2018contributors.repository.GithubRepository
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.withContext

interface DeleteCacheUseCase {
    suspend fun delete()
}

class DeleteCacheUseCaseImpl(private val githubRepository: GithubRepository) : DeleteCacheUseCase {
    override suspend fun delete() = withContext(CommonPool) {
        githubRepository.deleteContributors().await()
    }
}
