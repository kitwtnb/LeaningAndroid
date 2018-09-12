package com.kitwtnb.droidkaigi2018contributors.view.contributors

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import com.kitwtnb.droidkaigi2018contributors.R
import com.kitwtnb.droidkaigi2018contributors.databinding.ActivityContributorsBinding

class ContributorsActivity : AppCompatActivity() {
    companion object {
        fun createIntent(context: Context) = Intent(context, ContributorsActivity::class.java)
    }

    private val binding: ActivityContributorsBinding by lazy {
        DataBindingUtil.setContentView<ActivityContributorsBinding>(this, R.layout.activity_contributors)
    }
}
