package com.kitwtnb.droidkaigi2018contributors.view.contributors

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.usecase.ShowContributorsUseCase
import kotlinx.coroutines.experimental.CommonPool
import kotlinx.coroutines.experimental.launch
import kotlin.coroutines.experimental.CoroutineContext

class ContributorsViewModel(
        private val coroutineContext: CoroutineContext = CommonPool,
        private val showContributorsUseCase: ShowContributorsUseCase
) : ViewModel() {
    private val _contributors = MutableLiveData<List<Contributor>>()
    val contributors: LiveData<List<Contributor>> = _contributors

    fun onCreate() {
        launch(coroutineContext) {
            val contributors = showContributorsUseCase.showContributors()
            _contributors.value = contributors
        }
    }
}
