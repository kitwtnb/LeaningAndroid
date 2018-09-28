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
    private val _contributors: MutableLiveData<List<Contributor>> = MutableLiveData()
    val contributors: LiveData<List<Contributor>> = _contributors

    private val _isRefreshing: MutableLiveData<Boolean> = MutableLiveData()
    val isRefreshing: LiveData<Boolean> = _isRefreshing

    fun onCreate() = showContributors { showContributorsUseCase.showContributors() }

    fun onRefresh() = showContributors { showContributorsUseCase.refreshContributors() }

    private fun showContributors(getContributorsFunction: suspend () -> List<Contributor>) {
        launch(coroutineContext) {
            _isRefreshing.value = true
            val contributors = getContributorsFunction()
            _contributors.value = contributors
            _isRefreshing.value = false
        }
    }
}
