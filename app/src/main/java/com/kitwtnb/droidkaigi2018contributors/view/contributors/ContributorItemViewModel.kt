package com.kitwtnb.droidkaigi2018contributors.view.contributors

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.databinding.ObservableField
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor

class ContributorItemViewModel {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    private val _icon = MutableLiveData<String>()
    val icon: LiveData<String> = _icon

    fun setContributor(contributor: Contributor) {
        _name.value = contributor.login
        _icon.value = contributor.avatarUrl
    }
}
