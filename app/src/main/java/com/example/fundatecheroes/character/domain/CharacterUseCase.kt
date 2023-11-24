package com.example.fundatecheroes.character.domain

import com.example.fundatecheroes.character.data.repository.CharacterRepository
import java.time.LocalDateTime

class CharacterUseCase {

    private val repository by lazy {
        CharacterRepository()
    }

    suspend fun createCharacter(
        name:String,
        description: String,
        image: String,
        universeType: String,
        characterType: String,
        age: Int,
        birthday: LocalDateTime?
    ): Boolean {
        return repository.createCharacter(
            name = name,
            description = description,
            image = image,
            universeType = universeType,
            characterType = characterType,
            age = age,
            birthday = birthday
        )
    }

}