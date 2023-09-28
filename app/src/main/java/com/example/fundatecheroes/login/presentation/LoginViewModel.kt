package com.example.fundatecheroes.login.presentation

import android.util.Log
import androidx.lifecycle.ViewModel

class LoginViewModel: ViewModel() {

    fun validarInputs(email:String?, password:String?) {
        Log.e("Teste", email.toString())
        Log.e("Teste", password.toString())

    }
}