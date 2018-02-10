package com.kitwtnb.droidkaigi2018contributors

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val contributor: Contributor by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d("tags", contributor.name())
    }
}
