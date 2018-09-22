package com.kitwtnb.droidkaigi2018contributors.view.main

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.crashlytics.android.Crashlytics
import com.kitwtnb.droidkaigi2018contributors.datastore.service.ApiService
import com.kitwtnb.droidkaigi2018contributors.usecase.DeleteCacheUseCase
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.delay
import kotlinx.coroutines.experimental.launch
import timber.log.Timber

class MainViewModel(
        val apiService: ApiService,
        val deleteCacheUseCase: DeleteCacheUseCase
) : ViewModel() {
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

    fun onCreate() {
        launch(UI) {
            deleteCacheUseCase.delete()
        }
    }

    fun onClick() {
        Crashlytics.getInstance().crash()
    }
}
