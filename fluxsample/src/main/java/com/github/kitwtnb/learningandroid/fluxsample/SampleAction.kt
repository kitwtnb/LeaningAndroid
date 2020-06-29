package com.github.kitwtnb.learningandroid.fluxsample

sealed class SampleAction {
    data class Add(val number: Int): Action
}
