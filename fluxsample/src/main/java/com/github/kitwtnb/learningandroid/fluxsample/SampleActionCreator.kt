package com.github.kitwtnb.learningandroid.fluxsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.launch

@FlowPreview
@ExperimentalCoroutinesApi
class SampleActionCreator(
    private val dispatcher: Dispatcher,
    private val coroutineScope: CoroutineScope
) {
    fun add(value: Int) {
        coroutineScope.launch {
            dispatcher.dispatch(SampleAction.Add(value))
        }
    }
}
