package com.example.fundatecheroes.character.presentation.model

enum class UniverseType {

    MARVEL, DC;

    companion object {
        fun getValueOf(position: Int): String {
            return when (position) {
                1 -> MARVEL.name
                2 -> DC.name
                else -> throw IllegalArgumentException("Posição inválida")
            }
        }
    }
}

