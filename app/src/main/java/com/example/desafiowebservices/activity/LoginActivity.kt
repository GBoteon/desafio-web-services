package com.example.desafiowebservices.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservices.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button_login.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        button_signin.setOnClickListener {
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }
}