package com.kitwtnb.droidkaigi2018contributors

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.crashlytics.android.Crashlytics
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import timber.log.Timber

class MainViewModel(val apiService: ApiService) : ViewModel() {
    private val _text: MutableLiveData<String> = MutableLiveData()
    val text: LiveData<String> = _text

    init {
        launch(UI) {
            try {
                _text.value = "connecting..."
                delay(1000)
                apiService.randomUser.await().let { _text.value = it.results.first().name.first }
            } catch (t: Throwable) {
                Timber.e(t)
            }
        }

    }

    fun onClick() {
        Crashlytics.getInstance().crash()
    }
}
