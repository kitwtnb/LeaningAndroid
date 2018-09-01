package com.kitwtnb.droidkaigi2018contributors

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.crashlytics.android.Crashlytics
import com.google.android.gms.oss.licenses.OssLicensesMenuActivity
import com.kitwtnb.droidkaigi2018contributors.databinding.ActivityMainBinding
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.launch
import org.koin.android.ext.android.inject
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val contributor: Contributor by inject()
    private val api: ApiService by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setSupportActionBar(binding.toolbar)
        binding.text.text = contributor.name()
        binding.button.setOnClickListener { Crashlytics.getInstance().crash() }

        launch(UI) {
            try {
                api.randomUser.await().let { Timber.i(it.toString()) }
            } catch (t: Throwable) {
                Timber.e(t)
            }
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
