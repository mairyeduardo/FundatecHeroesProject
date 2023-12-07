package com.example.fundatecheroes.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toolbar
import androidx.activity.viewModels
import com.example.fundatecheroes.R
import com.example.fundatecheroes.character.view.CharacterActivity
import com.example.fundatecheroes.databinding.ActivityHomeBinding
import com.example.fundatecheroes.home.domain.CharacterModel
import com.example.fundatecheroes.home.presentation.HomeViewModel
import com.example.fundatecheroes.home.presentation.model.HomeViewState
import com.example.fundatecheroes.login.presentation.LoginViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private val adapter: CharacterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroes)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = adapter
        viewModel.state.observe(this) {
            when(it) {
                is HomeViewState.Success ->
                    adapter.addList(
                        it.list
                    )

                HomeViewState.Loading ->
                {

                }

                is HomeViewState.Error ->
                    it.errorMessage
            }

        }

        binding.floatingButtonAdicionarNovo.setOnClickListener{
            chamarTelaCriacaoPersonagem()
        }

    }

    private fun chamarTelaCriacaoPersonagem() {
        val intent = Intent(this@HomeActivity, CharacterActivity::class.java )
        startActivity(intent)
    }

}