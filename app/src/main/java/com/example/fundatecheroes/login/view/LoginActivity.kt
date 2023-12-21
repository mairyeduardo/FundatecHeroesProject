package com.example.fundatecheroes.login.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fundatecheroes.*
import com.example.fundatecheroes.databinding.ActivityLoginBinding
import com.example.fundatecheroes.home.view.HomeActivity
import com.example.fundatecheroes.login.presentation.LoginViewModel
import com.example.fundatecheroes.login.presentation.model.LoginViewState
import com.example.fundatecheroes.profile.view.ProfileActivity
import com.google.android.material.snackbar.Snackbar


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configButtonLogin()
        configNovoPorAqui()

        this.applicationContext


    }

    private fun configButtonLogin() {
        binding.buttonLogin.setOnClickListener{
            loginViewModel.validacaoPreenchimento(
                binding.loginEmail.text.toString(),
                binding.loginSenha.text.toString()
            )
        }
        loginViewModel.state.observe(this) {
            when(it) {
                LoginViewState.ShowEmailError ->
                    binding.loginEmail.showError(R.string.app_mensagem_erroEmailLogin)

                LoginViewState.ShowPasswordError ->
                    binding.loginSenha.showError(R.string.app_mensagem_erroPasswordLogin)

                LoginViewState.ShowHomeScreen -> chamarTelaHome()

                LoginViewState.ShowLoading ->
                    binding.progressBar.visible()

                LoginViewState.StopLoading ->
                    binding.progressBar.gone()

                LoginViewState.ShowEmailPasswordError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroLogin,
                    R.color.fundoHeroVermelho
                )

                LoginViewState.ShowError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroLoginInvalido,
                    R.color.fundoHeroVermelho
                )
            }
        }

    }

    private fun chamarTelaHome() {
        showSnackBar(
            binding.root,
            R.string.app_mensagem_sucessoLogin,
            R.color.fundoHeroVerdeSucesso
        )
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)
    }

    private fun configNovoPorAqui(){
        binding.usuarioNovo.setOnClickListener{
            chamarTelaProfile()
        }
    }

    private fun chamarTelaProfile() {
        val intent = Intent(this@LoginActivity, ProfileActivity::class.java )
        startActivity(intent)
    }
}

