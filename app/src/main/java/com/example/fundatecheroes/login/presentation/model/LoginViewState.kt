package com.example.fundatecheroes.login.presentation.model

sealed class LoginViewState {

    object ShowEmailPasswordError: LoginViewState()

    object ShowEmailError: LoginViewState()

    object ShowLoading: LoginViewState()

    object ShowError: LoginViewState()

    object ShowPasswordError: LoginViewState()
    object ShowHomeScreen: LoginViewState()
}