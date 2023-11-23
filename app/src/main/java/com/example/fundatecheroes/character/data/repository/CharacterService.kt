package com.example.fundatecheroes.character.data.repository

import com.example.fundatecheroes.character.data.CharacterRequest
import com.example.fundatecheroes.login.data.local.UserDao

import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CharacterService {

    @POST("/api/character/{idUser}")
    suspend fun createCharacter(
        @Path("idUser") idUser: Int,
        @Body characterRequest: CharacterRequest
    ): Response<ResponseBody>

}