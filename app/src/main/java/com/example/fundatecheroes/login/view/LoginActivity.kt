package com.example.fundatecheroes.login.view

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityLoginBinding
import com.example.fundatecheroes.home.view.HomeActivity
import com.example.fundatecheroes.profile.view.ProfileActivity


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configButtonLogin()
        configNovoPorAqui()

    }

    private fun configButtonLogin() {
        binding.buttonLogin.setOnClickListener{
            chamarTelaHome()
        }
    }

    private fun configNovoPorAqui(){
        binding.usuarioNovo.setOnClickListener{
            chamarTelaProfile()
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

