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
import com.example.fundatecheroes.showError
import com.example.fundatecheroes.showSnackBar
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
                ProfileViewState.ShowNameError ->
                    binding.onboardingNome.showError(R.string.app_mensagem_erroNomeOnboarding)
                ProfileViewState.ShowEmailError ->
                    binding.onboardingEmail.showError(R.string.app_mensagem_erroEmailOnboarding)
                ProfileViewState.ShowPasswordError ->
                    binding.onboardingSenha.showError(R.string.app_mensagem_erroPasswordOnboarding)
                ProfileViewState.ShowHomeScreen -> chamarTelaHome()
                ProfileViewState.ShowNameEmailPasswordError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroGeralCriacao,
                    R.color.fundoHeroVermelho
                )

            }
        }

    }

    private fun chamarTelaHome() {
        showSnackBar(
            binding.root,
            R.string.app_mensagem_sucessoCriacao,
            R.color.fundoHeroVerdeSucesso
        )
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}