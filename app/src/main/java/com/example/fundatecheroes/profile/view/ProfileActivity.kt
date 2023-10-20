package com.example.fundatecheroes.profile.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityProfileBinding
import com.example.fundatecheroes.home.view.HomeActivity
import com.example.fundatecheroes.profile.presentation.ProfileViewModel
import com.example.fundatecheroes.profile.presentation.model.ProfileViewState
//import com.example.fundatecheroes.profile.presentation.ProfileViewModel
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        binding.buttonCriarConta.setOnClickListener {
            profileViewModel.validacaoPreenchimento(
                binding.onboardingNome.text.toString(),
                binding.onboardingEmail.text.toString(),
                binding.onboardingSenha.text.toString()
            )
        }
        profileViewModel.state.observe(this) {
            when (it) {
                ProfileViewState.ShowEmailError -> chamarMensagemErro()
                ProfileViewState.ShowHomeScreen -> chamarTelaHome()
                ProfileViewState.ShowEmailPasswordError -> chamarMensagemErro()
            }
        }

    }

    private fun chamarTelaHome() {
        chamarMensagemSucesso()
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
            startActivity(intent)
        }, 3000)
    }

    private fun chamarMensagemSucesso() {
        Snackbar.make(
            binding.root,
            R.string.app_mensagem_sucessoCriacao,
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
            R.string.app_mensagem_erroCriacao,
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