package com.example.fundatecheroes.character.presentation.model

sealed class CharacterViewState {

    object ShowLoading: CharacterViewState()
    object StopLoading: CharacterViewState()
    object ShowNameError: CharacterViewState()
    object ShowDescriptionError: CharacterViewState()
    object ShowImageError: CharacterViewState()
    object ShowUniverseTypeError: CharacterViewState()
    object ShowCharacterTypeError: CharacterViewState()
    object ShowAgeError: CharacterViewState()
    object ShowBirthdayError: CharacterViewState()
    object ShowHomeScreen: CharacterViewState()

    object ShowGenericError: CharacterViewState()

}