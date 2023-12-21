package com.example.fundatecheroes.profile.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.*
import com.example.fundatecheroes.databinding.ActivityProfileBinding
import com.example.fundatecheroes.login.view.LoginActivity
import com.example.fundatecheroes.profile.presentation.ProfileViewModel
import com.example.fundatecheroes.profile.presentation.model.ProfileViewState

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    private val profileViewModel: ProfileViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configurarBotaoCriar()

    }

    private fun configurarBotaoCriar() {
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

                ProfileViewState.ShowLoginScreen ->
                    chamarTelaLogin()

                ProfileViewState.ShowNameEmailPasswordError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroGeralCriacao,
                    R.color.fundoHeroVermelho
                )

                ProfileViewState.ShowLoading ->
                    binding.progressBar.visible()

                ProfileViewState.StopLoading ->
                    binding.progressBar.gone()
            }
        }
    }

    private fun chamarTelaLogin() {
        showSnackBar(
            binding.root,
            R.string.app_mensagem_sucessoCriacao,
            R.color.fundoHeroVerdeSucesso
        )
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@ProfileActivity, LoginActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}