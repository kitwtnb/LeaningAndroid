package com.github.kitwtnb.learningandroid.fluxsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import kotlinx.android.synthetic.main.activity_flux_sample.add_value_button
import kotlinx.android.synthetic.main.activity_flux_sample.value_text
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@InternalCoroutinesApi
@FlowPreview
@ExperimentalCoroutinesApi
class FluxSampleActivity : AppCompatActivity() {
    private val dispatcher = Dispatcher()
    private val actionCreator = SampleActionCreator(dispatcher, GlobalScope)
    private val store = SampleStore(dispatcher, GlobalScope)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flux_sample)

        add_value_button.setOnClickListener {
            actionCreator.add(1)
        }

        lifecycleScope.launch {
            store.value.collect {
                value_text.text = "$it"
            }
        }
    }
}