package com.example.fundatecheroes.login.presentation.model

sealed class LoginViewState {

    object ShowEmailPasswordError: LoginViewState()

    object ShowEmailError: LoginViewState()

    object ShowHomeScreen: LoginViewState()
}