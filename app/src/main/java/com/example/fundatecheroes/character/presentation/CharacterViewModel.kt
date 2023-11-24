package com.example.fundatecheroes.character.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.character.domain.CharacterUseCase
import com.example.fundatecheroes.character.presentation.model.CharacterType
import com.example.fundatecheroes.character.presentation.model.CharacterViewState
import com.example.fundatecheroes.character.presentation.model.UniverseType
import com.example.fundatecheroes.login.presentation.model.LoginViewState
import kotlinx.coroutines.launch
import java.time.LocalDateTime

class CharacterViewModel : ViewModel() {

    private val useCase by lazy {
        CharacterUseCase()
    }

    private val viewState: MutableLiveData<CharacterViewState> = MutableLiveData()
    val state: LiveData<CharacterViewState> = viewState


    fun validarPreenchimento(
        name: String,
        description: String,
        image: String,
        universeType: Int,
        characterType: Int,
        age: String,
        birthday: String
    ) {
        if (name.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowNameError
            return
        } else if (description.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowDescriptionError
            return
        } else if (image.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowImageError
            return
        } else if (universeType == 0) {
            viewState.value = CharacterViewState.ShowUniverseTypeError
            return
        } else if (characterType == 0) {
            viewState.value = CharacterViewState.ShowCharacterTypeError
            return
        } else if (age.isNullOrBlank()) {
            viewState.value = CharacterViewState.ShowAgeError
            return
        }
//        else if (birthday.toString().isNullOrBlank()) {
//            viewState.value = CharacterViewState.ShowBirthdayError
//            return
//        }
            else {
            viewModelScope.launch {
                val isSuccess = useCase.createCharacter(
                    name = name,
                    description = description,
                    image = image,
                    universeType = UniverseType.getValueOf(universeType),
                    characterType = CharacterType.getValueOf(characterType),
                    age = age.toInt(),
                    birthday = null
                )
                if (isSuccess) {
                    viewState.value = CharacterViewState.ShowHomeScreen
                } else {
                    viewState.value = CharacterViewState.ShowGenericError
                }
            }
        }
    }

}