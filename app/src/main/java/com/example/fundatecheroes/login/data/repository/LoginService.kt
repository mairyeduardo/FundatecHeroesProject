package com.example.fundatecheroes.login.data.repository

import com.example.fundatecheroes.login.data.LoginRequest
import com.example.fundatecheroes.login.data.remote.LoginResponse
import okhttp3.ResponseBody
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query
import kotlin.reflect.jvm.internal.impl.incremental.components.LocationInfo

interface LoginService {


    @POST("api/login")
    suspend fun createUser(
        @Body loginRequest: LoginRequest
    ): Response<LoginResponse>


    @GET("api/login")
    suspend fun verificarUser(
        @Query("password") password: String,
        @Query("email") email: String
    ): Response<LoginResponse>

}