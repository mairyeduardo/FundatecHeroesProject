package com.example.fundatecheroes.home.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.character.domain.CharacterUseCase
import com.example.fundatecheroes.character.presentation.model.CharacterViewState
import com.example.fundatecheroes.home.domain.toModel
import com.example.fundatecheroes.home.presentation.model.HomeViewState
import com.example.fundatecheroes.login.presentation.model.LoginViewState
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val useCase by lazy {
        CharacterUseCase()
    }

    private val viewState: MutableLiveData<HomeViewState> = MutableLiveData()
    val state: LiveData<HomeViewState> = viewState

    private fun buscarInformacoes() {
        viewModelScope.launch {
            val listCharacter = useCase.listCharacter()
            if (listCharacter.isNotEmpty()) {
                viewState.value = HomeViewState.Success(listCharacter.toModel())
            }
            else {
                viewState.value = HomeViewState.Error("Lista Vazia")
            }
        }
    }

    init {
        buscarInformacoes()
    }

}