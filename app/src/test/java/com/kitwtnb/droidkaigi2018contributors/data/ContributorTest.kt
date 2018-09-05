package com.kitwtnb.droidkaigi2018contributors.data

import com.kitwtnb.droidkaigi2018contributors.di.jsonMapperModule
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.koin.standalone.StandAloneContext.closeKoin
import org.koin.standalone.StandAloneContext.startKoin
import org.koin.standalone.inject
import org.koin.test.KoinTest

class ContributorTest : KoinTest {
    val moshi: Moshi by inject()

    @Before
    fun setup() {
        startKoin(listOf(jsonMapperModule))
    }

    @After
    fun tearDown() {
        closeKoin()
    }

    @Test
    fun isCorrectConvertedFromJson() {
        val type = Types.newParameterizedType(List::class.java, Contributor::class.java)
        val jsonAdapter: JsonAdapter<List<Contributor>> = moshi.adapter(type)
        jsonAdapter.fromJson(json).run {
            // todo
        }
    }
}

val json = """
[
  {
    "login": "kitwtnb",
    "id": 19305363,
    "node_id": "MDQ6VXNlcjE5MzA1MzYz",
    "avatar_url": "https://avatars1.githubusercontent.com/u/19305363?v=4",
    "gravatar_id": "",
    "url": "https://api.github.com/users/kitwtnb",
    "html_url": "https://github.com/kitwtnb",
    "followers_url": "https://api.github.com/users/kitwtnb/followers",
    "following_url": "https://api.github.com/users/kitwtnb/following{/other_user}",
    "gists_url": "https://api.github.com/users/kitwtnb/gists{/gist_id}",
    "starred_url": "https://api.github.com/users/kitwtnb/starred{/owner}{/repo}",
    "subscriptions_url": "https://api.github.com/users/kitwtnb/subscriptions",
    "organizations_url": "https://api.github.com/users/kitwtnb/orgs",
    "repos_url": "https://api.github.com/users/kitwtnb/repos",
    "events_url": "https://api.github.com/users/kitwtnb/events{/privacy}",
    "received_events_url": "https://api.github.com/users/kitwtnb/received_events",
    "type": "User",
    "site_admin": false,
    "contributions": 61
  }
]
""".trimIndent()
