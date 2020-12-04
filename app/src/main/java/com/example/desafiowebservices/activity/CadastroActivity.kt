package com.example.desafiowebservices.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.desafiowebservices.R
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        button_save.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
        button_return_login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}