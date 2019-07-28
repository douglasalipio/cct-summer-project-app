package com.douglas.android.garageapp

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_garage.*
import kotlinx.android.synthetic.main.app_bar.*
import org.jetbrains.anko.toolbar

class GarageActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)
        setSupportActionBar(toolbar)
       // appBarConfiguration = AppBarConfiguration(navHostFragment.findNavController().graph)
        bottomView.setupWithNavController(navHostFragment.findNavController())

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navHostFragment.findNavController())
                || super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val retValue = super.onCreateOptionsMenu(menu)
        navHostFragment?.let {
            menuInflater.inflate(R.menu.bottom_menu, menu)
            return true
        }
        return retValue
    }

    override fun onSupportNavigateUp() = findNavController(navHostFragment).navigateUp()
}
