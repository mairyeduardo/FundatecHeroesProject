package com.example.fundatecheroes.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityHomeBinding
import com.example.fundatecheroes.home.domain.CharacterModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    private val adapter: CharacterListAdapter by lazy {
        CharacterListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.Theme_FundatecHeroes)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvList.adapter = adapter
        adapter.addList(
            listOf(
                CharacterModel(
                    name = "Venom",
                    image = "https://t.ctcdn.com.br/SBIRTmM0wCfRxC1OZ66Lk4-l7e4=/1024x576/smart/i527727.jpeg"
                ),
                CharacterModel(
                    name = "Knull",
                    image = "https://cdn.marvel.com/content/1x/kinginblack2020001_int-27.jpg"
                ),
                CharacterModel(
                    name = "Grito",
                    image = "http://www.guiadosquadrinhos.com/edicaoestrangeira/ShowImage.aspx?id=237492&path=ki1990001_237492.jpg"
                ),
                CharacterModel(
                    name = "Miranha",
                    image = "https://cdn.dicionariopopular.com/imagens/homem-aranha-meme-apontando-1-0.jpg"
                ),
            )
        )

        binding.btTest.setOnClickListener {
            adapter.remove(3)
        }

//        observerState(HomeViewState.HideButton)

    }

//    override fun onStart() {
//        super.onStart()
//    }
//
//    override fun onResume() {
//        super.onResume()
//    }
//
//    override fun onStop() {
//        super.onStop()
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//    }

//    private fun observerState(state: HomeViewState){
//        when(state){
//            is HomeViewState.Sucess -> {
//                state.message
//            }
//            is HomeViewState.Error -> {
//                state.errorMessage
//            }
//            HomeViewState.Loading -> {
//
//            }
//            HomeViewState.HideButton -> {
//             //   button.gone()
//            }
//
//        }
//    }
}