package com.kitwtnb.droidkaigi2018contributors.view.contributors

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.kitwtnb.droidkaigi2018contributors.R
import com.kitwtnb.droidkaigi2018contributors.databinding.ActivityContributorsBinding
import com.kitwtnb.droidkaigi2018contributors.ext.observeNonNull
import org.koin.android.ext.android.inject

class ContributorsActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, ContributorsActivity::class.java)
    }

    private val viewModel: ContributorsViewModel by inject()
    private val binding: ActivityContributorsBinding by lazy {
        DataBindingUtil.setContentView<ActivityContributorsBinding>(this, R.layout.activity_contributors)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.contributors.let {
            it.layoutManager = GridLayoutManager(this, 2)
            it.adapter = ContributorAdapter()
        }
        viewModel.contributors.observeNonNull(this) {
            val adapter = binding.contributors.adapter as ContributorAdapter
            adapter.setContributors(it)
        }

        viewModel.onCreate()
    }
}
