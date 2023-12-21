package com.example.fundatecheroes.home.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.fundatecheroes.R
import com.example.fundatecheroes.character.view.CharacterActivity
import com.example.fundatecheroes.character.view.CharacterDetailActivity
import com.example.fundatecheroes.databinding.ActivityHomeBinding
import com.example.fundatecheroes.gone
import com.example.fundatecheroes.home.domain.CharacterModel
import com.example.fundatecheroes.home.presentation.HomeViewModel
import com.example.fundatecheroes.home.presentation.model.HomeViewState
import com.example.fundatecheroes.showSnackBar
import com.example.fundatecheroes.visible

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private val viewModel: HomeViewModel by viewModels()

    private val adapter: CharacterListAdapter by lazy {
        CharacterListAdapter() {
            Log.e("Home Activity", it.toString())
            chamarTelaDetalhesDoPersonagem(it)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroes)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = adapter
        viewModel.state.observe(this) {
            when (it) {
                is HomeViewState.Success ->
                    adapter.addList(
                        it.list
                    )

                is HomeViewState.CharacterRemove ->
                    showSnackBar(
                        binding.root,
                        R.string.app_mensagem_sucessoRemover_personagem,
                        R.color.fundoHeroVerdeSucesso)

                HomeViewState.ShowLoading -> {
                    binding.progressBar.visible()
                }

                HomeViewState.StopLoading -> {
                    binding.progressBar.gone()
                }

                is HomeViewState.Error ->
                    it.errorMessage
            }

        }

        binding.floatingButtonAdicionarNovo.setOnClickListener {
            chamarTelaCriacaoPersonagem()
        }
        configSwipeToRemove()
    }

    private fun configSwipeToRemove() {
        ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            override fun onMove(v: RecyclerView, h: RecyclerView.ViewHolder, t: RecyclerView.ViewHolder) = false

            override fun onSwiped(h: RecyclerView.ViewHolder, dir: Int) {
                val character = adapter.retrieveCharacter(h.adapterPosition)
                viewModel.removerPersonagem(character.id)
                adapter.removeAt(h.adapterPosition)
            }
        }).attachToRecyclerView(binding.rvList)
    }


    private fun chamarTelaCriacaoPersonagem() {
        val intent = Intent(this@HomeActivity, CharacterActivity::class.java)
        startActivity(intent)
    }

    private fun chamarTelaDetalhesDoPersonagem(characterModel: CharacterModel) {
        val intent = Intent(this@HomeActivity, CharacterDetailActivity::class.java)
        intent.putExtra("character", characterModel);
        startActivity(intent)
    }

    override fun onBackPressed() {
        finish()
        super.onBackPressed()
    }

}