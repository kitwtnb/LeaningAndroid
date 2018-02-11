package com.kitwtnb.droidkaigi2018contributors

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.kitwtnb.droidkaigi2018contributors.databinding.ActivityMainBinding
import io.reactivex.rxkotlin.subscribeBy
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val contributor: Contributor by inject()
    private val api: ApiService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.text.text = contributor.name()
        api.randomUser.subscribeBy(
            onSuccess = { Timber.i(it.toString()) },
            onError = { Timber.e(it) }
        )
    }
}
