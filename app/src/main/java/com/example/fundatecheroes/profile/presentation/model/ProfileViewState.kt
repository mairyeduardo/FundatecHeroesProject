package com.example.fundatecheroes.profile.presentation.model

sealed class ProfileViewState {


    object ShowEmailPasswordError: ProfileViewState()
    object ShowEmailError: ProfileViewState()
    object ShowHomeScreen: ProfileViewState()


}