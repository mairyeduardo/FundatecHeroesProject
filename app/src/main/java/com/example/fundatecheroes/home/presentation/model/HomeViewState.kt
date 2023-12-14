package com.example.fundatecheroes.home.presentation.model

import com.example.fundatecheroes.home.domain.CharacterModel

sealed class HomeViewState {
    data class Success(val list: List<CharacterModel>) : HomeViewState()

    object CharacterRemove : HomeViewState()
    object Loading : HomeViewState()
    data class Error(val errorMessage: String) : HomeViewState()
}
