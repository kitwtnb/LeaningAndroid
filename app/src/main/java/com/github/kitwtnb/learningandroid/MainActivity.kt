package com.github.kitwtnb.learningandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.github.kitwtnb.learningandroid.fluxsample.FluxSampleActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.InternalCoroutinesApi

@InternalCoroutinesApi
@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hash_text.text = viewModel.appHash

        go_to_flux_sample_button.setOnClickListener {
            val intent = Intent(this, FluxSampleActivity::class.java)
            startActivity(intent)
        }
    }
}