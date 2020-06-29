package com.github.kitwtnb.learningandroid.fluxsample

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@FlowPreview
@ExperimentalCoroutinesApi
class SampleStore(
    dispatcher: Dispatcher,
    coroutineScope: CoroutineScope
) {
    private val _value = MutableStateFlow(0)
    val value: StateFlow<Int> = _value

    init {
        coroutineScope.launch {
            dispatcher.observe<SampleAction.Add>().collect {
                _value.value += it.number
            }
        }
    }
}
