package com.kitwtnb.droidkaigi2018contributors

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private val _text: MutableLiveData<String> = MutableLiveData()
    val text: LiveData<String> = _text

    init {
        _text.value = "initialize view model."
    }
}
