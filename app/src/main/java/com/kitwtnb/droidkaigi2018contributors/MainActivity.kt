package com.kitwtnb.droidkaigi2018contributors

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import io.reactivex.rxkotlin.subscribeBy
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val contributor: Contributor by inject()
    private val api: ApiService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d(contributor.name())
        api.randomUser.subscribeBy(
            onSuccess = { Timber.i(it.toString()) },
            onError = { Timber.e(it) }
        )
    }
}
