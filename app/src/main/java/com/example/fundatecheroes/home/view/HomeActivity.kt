package com.example.fundatecheroes.home.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.fundatecheroes.R
import com.example.fundatecheroes.gone
import com.example.fundatecheroes.home.presentation.model.HomeViewState

class HomeActivity : AppCompatActivity() {
    private val button by lazy {
        findViewById<Button>(R.id.button)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        observerState(HomeViewState.HideButton)

    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    private fun observerState(state: HomeViewState){
        when(state){
            is HomeViewState.Sucess -> {
                state.message
            }
            is HomeViewState.Error -> {
                state.errorMessage
            }
            HomeViewState.Loading -> {

            }
            HomeViewState.HideButton -> {
                button.gone()
            }

        }
    }

}

