package com.example.fundatecheroes.splash.view

import SplashViewModel
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.databinding.ActivitySplashBinding
import com.example.fundatecheroes.home.view.HomeActivity
import com.example.fundatecheroes.login.view.LoginActivity

import com.example.fundatecheroes.splash.view.presentation.model.SplashViewState

private const val DELAY_TELA = 3000L

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModels()
    private lateinit var binding: ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        viewModel.state.observe(this) { state ->
            when (state) {
                SplashViewState.ShowLogin -> fazerLogin()
                SplashViewState.ShowHome -> showHome()
            }
        }
    }


    private fun fazerLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this@SplashActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY_TELA)
    }

    private fun showHome() {
        Handler(Looper.getMainLooper()).postDelayed({
            startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            finish()
        }, DELAY_TELA)
    }
}