package com.example.fundatecheroes.character.view

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityDetailsCharacterBinding
import com.example.fundatecheroes.home.domain.CharacterModel

class CharacterDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailsCharacterBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsCharacterBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        val character = intent.extras?.getSerializable("character") as? CharacterModel
        if (character == null) {
            finish()
            return
        }
        binding.textNomePersonagem.text = character.name
        binding.textDescricaoPersonagem.text = getString(R.string.character_detail_description, character.description)
        binding.textIdadePersonagem.text = getString(R.string.character_detail_age, character.age.toString())
        binding.textNascimentoPersonagem.text = getString(R.string.character_detail_birthday, character.date)
        Log.e("teste", character.toString())
    }
}