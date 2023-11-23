package com.example.fundatecheroes.character.data.remote

import java.time.LocalDateTime

data class CharacterResponse (
    val id: Int,
    val name:String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Int,
    val birthday: LocalDateTime?
)