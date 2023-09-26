package com.example.fundatecheroes.home.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.R


class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_login)

        findViewById<TextView>(R.id.usuario_novo).setOnClickListener{
            chamarTelaProfile()
        }

        findViewById<Button>(R.id.buttonLogin).setOnClickListener {
            chamarTelaHome()
        }
    }

    private fun chamarTelaHome() {
        val intent = Intent(this@LoginActivity, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun chamarTelaProfile() {
        val intent = Intent(this@LoginActivity, ProfileActivity::class.java )
        startActivity(intent)
    }

}

