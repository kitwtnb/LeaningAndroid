package com.kitwtnb.droidkaigi2018contributors

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import org.koin.android.ext.android.inject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val contributor: Contributor by inject()
    private val api: ApiService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.d(contributor.name())
        api.randomUser.enqueue(object :Callback<RandomUser> {
            override fun onFailure(call: Call<RandomUser>?, t: Throwable?) {
                Timber.i("fail")
            }

            override fun onResponse(call: Call<RandomUser>?, response: Response<RandomUser>?) {
                if (response?.body() != null) {
                    Timber.i(response.body().toString())
                }
            }
        })
    }
}
