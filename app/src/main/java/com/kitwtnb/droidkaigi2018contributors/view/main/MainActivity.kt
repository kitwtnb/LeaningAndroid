package com.kitwtnb.droidkaigi2018contributors.view.main

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.kitwtnb.droidkaigi2018contributors.R
import com.kitwtnb.droidkaigi2018contributors.databinding.ActivityMainBinding
import com.kitwtnb.droidkaigi2018contributors.view.contributors.ContributorsActivity
import org.koin.android.architecture.ext.viewModel

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)

        binding.setLifecycleOwner(this)
        binding.viewModel = viewModel

        binding.showContributors.setOnClickListener {
            ContributorsActivity.createIntent(this).let { startActivity(it) }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if (item!!.itemId == R.id.oss_licenses) {
            startActivity(Intent(this, OssLicensesMenuActivity::class.java))
        }

        return super.onOptionsItemSelected(item)
    }
}
