package com.example.fundatecheroes.character.data.repository

import android.util.Log
import com.example.fundatecheroes.character.data.CharacterRequest
import com.example.fundatecheroes.database.FHDatabase
import com.example.fundatecheroes.login.data.repository.LoginRepository
import com.example.fundatecheroes.network.RetrofitNetworkClient
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime

class CharacterRepository {

    private val repository = RetrofitNetworkClient.createNetworkClient(
        baseUrl = "https://fundatec.herokuapp.com"
    ).create(CharacterService::class.java)

    private val loginRepository: LoginRepository by lazy {
        LoginRepository()
    }


    suspend fun createCharacter(
        name: String,
        description: String,
        image: String,
        universeType: String,
        characterType: String,
        age: Int,
        birthday: LocalDateTime?): Boolean {
        return withContext(Dispatchers.IO) {
            try {
                val response = repository.createCharacter(
                    idUser = loginRepository.pegarId(),
                    characterRequest = CharacterRequest(
                        name = name,
                        description = description,
                        image = image,
                        universeType = universeType,
                        characterType = characterType,
                        age = age,
                        birthday = null
                    )
                )
                response.isSuccessful
            } catch (ex: Exception) {
                Log.e("createCharacter", ex.message.toString())
                false
            }
        }
    }


}