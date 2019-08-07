package com.douglas.android.garageapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI.setupWithNavController
import kotlinx.android.synthetic.main.acitivity_content.*
import kotlinx.android.synthetic.main.activity_garage.*


class GarageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_garage)
        setSupportActionBar(toolbar)
        setupWithNavController(bottomView, navHostFragment.findNavController())
    }

    override fun onSupportNavigateUp() = findNavController(navHostFragment).navigateUp()

}
