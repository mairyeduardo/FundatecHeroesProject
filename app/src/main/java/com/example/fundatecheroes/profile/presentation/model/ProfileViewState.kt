package com.example.fundatecheroes.profile.presentation.model

sealed class ProfileViewState {

    object ShowLoading: ProfileViewState()
    object StopLoading: ProfileViewState()
    object ShowNameEmailPasswordError: ProfileViewState()
    object ShowNameError: ProfileViewState()
    object ShowEmailError: ProfileViewState()
    object ShowPasswordError: ProfileViewState()
    object ShowLoginScreen: ProfileViewState()


}