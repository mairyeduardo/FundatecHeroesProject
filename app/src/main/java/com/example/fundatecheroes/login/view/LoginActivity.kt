package com.example.fundatecheroes.login.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fundatecheroes.R
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

    //  Ajustar, está errado;
    //        viewModel.validarInputs(binding.inputLoginEmail.toString(), binding.inputLoginSenha.toString())
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
                LoginViewState.ShowEmailError -> chamarMensagemErro()
                LoginViewState.ShowHomeScreen -> chamarTelaHome()
                LoginViewState.ShowEmailPasswordError -> chamarMensagemErro()
            }
        }

    }

    private fun chamarTelaHome() {
        chamarMensagemSucesso()
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@LoginActivity, HomeActivity::class.java)
            startActivity(intent)
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

    private fun chamarMensagemSucesso() {
        Snackbar.make(
            binding.root,
            R.string.app_mensagem_sucessoLogin,
            Snackbar.LENGTH_SHORT
        )
            .setActionTextColor(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            )
            .setBackgroundTint(ContextCompat.getColor(this, R.color.fundoHeroVerdeSucesso))
            .show()
    }

    private fun chamarMensagemErro() {
        Snackbar.make(
            binding.root,
            R.string.app_mensagem_erroLogin,
            Snackbar.LENGTH_SHORT
        )
            .setActionTextColor(
                ColorStateList.valueOf(
                    ContextCompat.getColor(
                        this,
                        R.color.white
                    )
                )
            )
            .setBackgroundTint(ContextCompat.getColor(this, R.color.fundoHeroVermelho))
            .show()
    }


}

