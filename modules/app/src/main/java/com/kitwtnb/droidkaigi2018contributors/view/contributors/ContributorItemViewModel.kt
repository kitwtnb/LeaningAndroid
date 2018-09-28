package com.kitwtnb.droidkaigi2018contributors.view.contributors

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor

class ContributorItemViewModel(contributor: Contributor) {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _icon = MutableLiveData<String>()
    val icon: LiveData<String> = _icon

    init {
        _name.value = contributor.login
        _icon.value = contributor.avatarUrl
    }
}
