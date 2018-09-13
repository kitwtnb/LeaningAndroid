package com.kitwtnb.droidkaigi2018contributors.view.contributors

import android.app.Activity
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.kitwtnb.droidkaigi2018contributors.R
import com.kitwtnb.droidkaigi2018contributors.databinding.ViewContributorItemBinding
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor

class ContributorAdapter(private val contributors: List<Contributor>) : RecyclerView.Adapter<ContributorAdapter.BindingHolder>() {
    class BindingHolder(val binding: ViewContributorItemBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val binding = DataBindingUtil.setContentView<ViewContributorItemBinding>(parent.context as Activity, R.layout.view_contributor_item).also {
            it.viewModel = ContributorItemViewModel()
        }
        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.binding.viewModel!!.setContributor(contributors[position])
    }

    override fun getItemCount() = contributors.size
}
