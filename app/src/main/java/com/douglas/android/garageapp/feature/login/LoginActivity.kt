package com.douglas.android.garageapp.feature.login


import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.douglas.android.garageapp.GarageActivity
import com.douglas.android.garageapp.R
import com.google.firebase.auth.FirebaseAuth


import kotlinx.android.synthetic.main.login.*
import org.jetbrains.anko.toast

class LoginActivity : AppCompatActivity() {

    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        initComponents()
    }

    private fun initComponents() {
        loginButton?.setOnClickListener { startActivity(Intent(this, MemberActivity::class.java)) }
        createAccountBtn?.setOnClickListener { registerUser() }
    }

    override fun onStart() {
        super.onStart()
        validateUser()
    }

    private fun validateUser() {
        if (auth.currentUser != null)
            startActivity(Intent(this, GarageActivity::class.java))
    }

    private fun registerUser() {
        auth.createUserWithEmailAndPassword(loginEmail?.text.toString(), loginPassword?.text.toString())
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful)
                    startActivity(Intent(this, GarageActivity::class.java))
                else
                    toast(task.exception?.message.toString())
            }
    }
}