package com.kitwtnb.droidkaigi2018contributors.view.contributors

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor

class ContributorItemViewModel {
    private val _name = MutableLiveData<String>()
    val name: LiveData<String> = _name

    fun setContributor(contributor: Contributor) {
        _name.value = contributor.login
    }
}
