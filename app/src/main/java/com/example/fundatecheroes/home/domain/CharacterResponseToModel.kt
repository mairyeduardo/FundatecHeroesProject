package com.example.fundatecheroes.home.domain

import com.example.fundatecheroes.character.data.remote.CharacterResponse

fun List<CharacterResponse>.toModel(): List<CharacterModel> {
    return map {character ->
        CharacterModel(
            id = character.id,
            name = character.name,
            image = character.image
        )
    }
}