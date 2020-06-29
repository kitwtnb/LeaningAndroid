package com.github.kitwtnb.learningandroid.fluxsample

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.mapNotNull

@FlowPreview
@ExperimentalCoroutinesApi
class Dispatcher {
    private val channel = BroadcastChannel<Action>(Channel.CONFLATED)

    suspend fun dispatch(action: Action) {
        channel.send(action)
    }

    @Suppress("UNCHECKED_CAST")
    fun <T : Action> observe(): Flow<T> = channel
        .asFlow()
        .mapNotNull { it as? T }
}
