package com.example.fundatecheroes.character.view

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.PersistableBundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.fundatecheroes.R
import com.example.fundatecheroes.character.presentation.CharacterViewModel
import com.example.fundatecheroes.character.presentation.model.CharacterViewState
import com.example.fundatecheroes.databinding.ActivityCharacterBinding
import com.example.fundatecheroes.home.view.HomeActivity
import com.example.fundatecheroes.showError
import com.example.fundatecheroes.showSnackBar

private const val DELAY_TELA = 3000L

class CharacterActivity: AppCompatActivity() {

    private lateinit var binding: ActivityCharacterBinding
    private val characterViewModel: CharacterViewModel by viewModels()


    val Personagem = arrayOf("Personagem","Herói", "Vilão")
    val Universo = arrayOf("Universo","Marvel", "DC")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCharacterBinding.inflate(layoutInflater)
        getSupportActionBar()?.hide()
        setContentView(binding.root)

        configButtonCriarPersonagem()
        itensSpinerPersonagem()
        itensSpinerUniverso()
    }


    private fun configButtonCriarPersonagem(){
        binding.floatingButtonCriar.setOnClickListener{
            characterViewModel.validarPreenchimento(
                binding.editTextCampoNome.text.toString(),
                binding.editTextCampoDescricao.text.toString(),
                binding.editTextCampoUrl.text.toString(),
                binding.spinnerUniversoPersonagem.selectedItemPosition,
                binding.spinnerTipoPersonagem.selectedItemPosition,
                binding.editTextCampoIdade.text.toString(),
                binding.pickTime.text.toString(),
            )
        }
        characterViewModel.state.observe(this) {
            when(it) {

                CharacterViewState.ShowNameError ->
                    binding.editTextCampoNome.showError(R.string.app_mensagem_nome_personagem)

                CharacterViewState.ShowDescriptionError ->
                    binding.editTextCampoDescricao.showError(R.string.app_mensagem_descricao_personagem)

                CharacterViewState.ShowImageError ->
                    binding.editTextCampoUrl.showError(R.string.app_mensagem_url_personagem)

                CharacterViewState.ShowUniverseTypeError -> showSnackBar(
                    binding.spinnerUniversoPersonagem,
                    R.string.app_mensagem_universo_personagem,
                    R.color.fundoHeroVermelho
                )

                CharacterViewState.ShowCharacterTypeError -> showSnackBar(
                    binding.spinnerTipoPersonagem,
                    R.string.app_mensagem_tipo_personagem,
                    R.color.fundoHeroVermelho
                )

                CharacterViewState.ShowAgeError ->
                    binding.editTextCampoIdade.showError(R.string.app_mensagem_idade_personagem)

                CharacterViewState.ShowBirthdayError -> showSnackBar(
                    binding.pickTime,
                    R.string.app_mensagem_data_personagem,
                    R.color.fundoHeroVermelho
                )

                CharacterViewState.ShowGenericError -> showSnackBar(
                    binding.root,
                    R.string.app_mensagem_erroGenerico_personagem,
                    R.color.fundoHeroVermelho
                )

                CharacterViewState.ShowHomeScreen -> chamarTelaHome()

            }
        }
    }

    private fun chamarTelaHome() {
        showSnackBar(
            binding.root,
            R.string.app_mensagem_sucessoCriar_personagem,
            R.color.fundoHeroVerdeSucesso
        )
        val handle = Handler()
        handle.postDelayed({
            val intent = Intent(this@CharacterActivity, HomeActivity::class.java)
            startActivity(intent)
            finish()
        }, DELAY_TELA)
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