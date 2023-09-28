package com.example.fundatecheroes.splash.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivitySplashBinding
import com.example.fundatecheroes.login.view.LoginActivity

private const val DELAY_TELA = 3000L

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        Handler(Looper.getMainLooper()).postDelayed({ fazerLogin() }, DELAY_TELA)
    }

    private fun fazerLogin() {
        val intent = Intent(this@SplashActivity, LoginActivity::class.java)
        startActivity(intent)
        finish()
    }

}