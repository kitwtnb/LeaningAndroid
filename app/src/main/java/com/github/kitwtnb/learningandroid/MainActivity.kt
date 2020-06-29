package com.github.kitwtnb.learningandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kitwtnb.learningandroid.fluxsample.FluxSampleActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @Inject lateinit var appHash: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        hash_text.text = appHash

        go_to_flux_sample_button.setOnClickListener {
            val intent = Intent(this, FluxSampleActivity::class.java)
            startActivity(intent)
        }
    }
}