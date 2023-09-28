package com.example.fundatecheroes.profile.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityLoginBinding
import com.example.fundatecheroes.databinding.ActivityProfileBinding
import com.example.fundatecheroes.home.view.HomeActivity
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {

    private lateinit var binding: ActivityProfileBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProfileBinding.inflate(layoutInflater)

        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val editTextN1 = binding.onboardingNome
        val edittextN2 = binding.onboardingEmail
        val edittextN3 = binding.onboardingSenha

        binding.buttonCriarConta.setOnClickListener {
            validacaoPreenchimento(editTextN1, edittextN2, edittextN3)
        }

    }

    private fun validacaoPreenchimento(
        editText: EditText,
        editText2: EditText,
        editText3: EditText
    ) {

        if (editText.text.toString().isEmpty() || editText2.text.toString()
                .isEmpty() || editText3.text.toString().isEmpty()
        ) {
            chamarMensagemErro()
        } else if (editText2.text.toString().contains("@") && editText2.text.toString()
                .contains(".com")
        ) {
            chamarMensagemSucesso()
        } else {
            chamarMensagemErro()
        }
    }

    private fun chamarTelaHome() {
        val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
        startActivity(intent)
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

        val handle = Handler()
        handle.postDelayed({ chamarTelaHome() }, 3000)
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