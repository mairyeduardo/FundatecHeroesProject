package com.example.fundatecheroes.login.presentation

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fundatecheroes.login.presentation.model.LoginViewState

class LoginViewModel: ViewModel() {

    private val viewState: MutableLiveData<LoginViewState> = MutableLiveData()
    val state: LiveData<LoginViewState> = viewState

    fun validacaoPreenchimento(
        email:String,
        password:String
    ) {
        if (email.isEmpty() || password.isEmpty()) {
            viewState.value = LoginViewState.ShowEmailPasswordError
        } else if(email.contains("@") && email.contains(".com")) {
            viewState.value = LoginViewState.ShowHomeScreen
        } else {
            viewState.value = LoginViewState.ShowEmailError
        }

    }
}