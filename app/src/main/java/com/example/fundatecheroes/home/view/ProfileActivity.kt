package com.example.fundatecheroes.home.view

import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.fundatecheroes.R
import com.google.android.material.snackbar.Snackbar

class ProfileActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        getSupportActionBar()?.hide()
        setContentView(R.layout.activity_profile)

        var editTextN1 = findViewById<EditText>(R.id.onboardingNome);
        var edittextN2 = findViewById<EditText>(R.id.onboardingEmail);
        var edittextN3 = findViewById<EditText>(R.id.onboardingSenha);

        findViewById<Button>(R.id.buttonCriarConta).setOnClickListener() {
            verificarVazio(editTextN1, edittextN2, edittextN3)
        }
    }

    private fun verificarVazio(editText: EditText, editText2: EditText, editText3: EditText) {

        editText.text.toString().isEmpty()
        editText2.text.toString().isEmpty()
        editText3.text.toString().isEmpty()

        if(editText.text.toString().isEmpty() || editText2.text.toString().isEmpty() || editText3.text.toString().isEmpty()){
            chamarMensagemErro()
        } else {
            chamarMensagemSucesso()
        }
    }

    private fun chamarTelaHome() {
        val intent = Intent(this@ProfileActivity, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun chamarMensagemSucesso() {
        Snackbar.make(
            findViewById(android.R.id.content),
            R.string.app_sucessoCriacao,
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
            findViewById(android.R.id.content),
            R.string.app_erroCriacao,
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