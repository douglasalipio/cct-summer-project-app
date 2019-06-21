package com.douglas.android.garageapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_garage.*
import org.jetbrains.anko.toast

class GarageActivity : AppCompatActivity() {

    private lateinit var textMessage: TextView


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottom_bar_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.app_bar_fav -> toast(getString(R.string.fav_clicked))
            R.id.app_bar_search -> toast(getString(R.string.search_clicked))
            R.id.app_bar_settings -> toast(getString(R.string.settings_clicked))
            android.R.id.home -> {
                val bottomNavDrawerFragment = BottomNavigationDrawerFragment()
                bottomNavDrawerFragment.show(supportFragmentManager, bottomNavDrawerFragment.tag)
            }
        }
        return true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)
        setSupportActionBar(bottomBar)
        //textMessage = findViewById(R.id.message)
        //navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }
}
