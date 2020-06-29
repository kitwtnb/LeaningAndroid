package com.github.kitwtnb.learningandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.kitwtnb.learningandroid.fluxsample.FluxSampleActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        go_to_flux_sample_button.setOnClickListener {
            val intent = Intent(this, FluxSampleActivity::class.java)
            startActivity(intent)
        }
    }
}