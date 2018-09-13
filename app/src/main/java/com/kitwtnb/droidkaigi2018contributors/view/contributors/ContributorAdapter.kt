package com.kitwtnb.droidkaigi2018contributors.view.contributors

import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.kitwtnb.droidkaigi2018contributors.databinding.ViewContributorItemBinding
import com.kitwtnb.droidkaigi2018contributors.datastore.data.Contributor

class ContributorAdapter : RecyclerView.Adapter<ContributorAdapter.BindingHolder>() {
    class BindingHolder(val binding: ViewContributorItemBinding) : RecyclerView.ViewHolder(binding.root)

    private val contributors = mutableListOf<Contributor>()

    override fun getItemCount() = contributors.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
        val activity = parent.context as AppCompatActivity
        val inflater = LayoutInflater.from(parent.context)
        val binding = ViewContributorItemBinding.inflate(inflater, parent, false).also {
            it.setLifecycleOwner(activity)
            it.viewModel = ContributorItemViewModel()
        }

        return BindingHolder(binding)
    }

    override fun onBindViewHolder(holder: BindingHolder, position: Int) {
        holder.binding.viewModel!!.setContributor(contributors[position])
    }

    fun setContributors(contributors: List<Contributor>) {
        this.contributors.addAll(contributors)
        notifyDataSetChanged()
    }
}
