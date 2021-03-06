package com.douglas.android.garageapp.features.login

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.douglas.android.garageapp.GarageActivity
import com.douglas.android.garageapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.member.*
import org.jetbrains.anko.sdk27.coroutines.onClick
import org.jetbrains.anko.toast

class MemberActivity : AppCompatActivity() {

    private var auth = FirebaseAuth.getInstance()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.member)
        initComponents()
    }

    private fun initComponents() {
        memberLogin?.onClick { doLogin() }
    }

    private fun doLogin() {
        auth.signInWithEmailAndPassword(memberEmail?.text.toString(), memberPassword?.text.toString())
            .addOnCompleteListener { task ->
                if (task.isSuccessful)
                    startActivity(Intent(this, GarageActivity::class.java))
                else
                    toast(task.exception?.message.toString())
            }
    }
}