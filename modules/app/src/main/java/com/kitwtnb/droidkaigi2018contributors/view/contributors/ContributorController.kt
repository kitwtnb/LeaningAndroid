package com.kitwtnb.droidkaigi2018contributors.view.contributors

import com.airbnb.epoxy.TypedEpoxyController
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor
import com.kitwtnb.droidkaigi2018contributors.viewContributorItem

class ContributorController : TypedEpoxyController<List<Contributor>>() {
    override fun buildModels(contributors: List<Contributor>) {
        contributors.forEach {
            viewContributorItem {
                id(modelCountBuiltSoFar)
                viewModel(ContributorItemViewModel(it))
            }
        }
    }
}
