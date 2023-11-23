package com.example.fundatecheroes.character.data

import java.time.LocalDateTime

data class CharacterRequest (
    val name:String,
    val description: String,
    val image: String,
    val universeType: String,
    val characterType: String,
    val age: Int,
    val birthday: LocalDateTime?
)
