package com.example.fundatecheroes.character.view

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityCharacterBinding

class CharacterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding

    val Personagem = arrayOf("Herói", "Vilão")
    val Universo = arrayOf("Marvel", "DC", "Desconhecido")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        itensSpinerPersonagem()
        itensSpinerUniverso()
    }

    private fun itensSpinerPersonagem() {
        val spinner = findViewById<Spinner>(R.id.spinner_tipo_personagem)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            Personagem
        )
        spinner.adapter = arrayAdapter
    }

    private fun itensSpinerUniverso() {
        val spinner = findViewById<Spinner>(R.id.spinner_universo_personagem)
        val arrayAdapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_spinner_dropdown_item,
            Universo
        )
        spinner.adapter = arrayAdapter
    }


}