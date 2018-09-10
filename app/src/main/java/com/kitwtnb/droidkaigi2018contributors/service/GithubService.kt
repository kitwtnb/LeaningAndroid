package com.kitwtnb.droidkaigi2018contributors.service

import com.kitwtnb.droidkaigi2018contributors.data.Contributor
import kotlinx.coroutines.experimental.Deferred
import retrofit2.http.GET
import retrofit2.http.Path

interface GithubService {
    @GET("repos/{owner}/{repository}/contributors")
    fun contributors(
            @Path("owner") owner: String,
            @Path("repository") repository: String
    ): Deferred<List<Contributor>>
}