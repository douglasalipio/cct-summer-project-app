package com.douglas.android.garageapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.douglas.android.garageapp.feature.book.BookDetailFragment
import kotlinx.android.synthetic.main.activity_garage.*
import org.jetbrains.anko.toast

class GarageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)
        setSupportActionBar(bottomBar)
        initComponent()
    }

    private fun initComponent() {
        tabs.setupWithViewPager(ViewPager(this))
        bookService?.setOnClickListener {
            val bottomNavDrawerFragment = BookDetailFragment()
            bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {

            R.id.receiptLabel -> toast(getString(R.string.fav_clicked))

            R.id.settingsLabel -> toast(getString(R.string.settings_clicked))

            android.R.id.home -> {
                val bottomNavDrawerFragment = GarageSheetDialog()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }
        return true
    }

}
