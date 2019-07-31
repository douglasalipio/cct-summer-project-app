package com.douglas.android.garageapp.feature.login

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.douglas.android.garageapp.R
import com.google.firebase.auth.FirebaseAuth

class MemberActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.member)
    }
}