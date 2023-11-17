package com.example.fundatecheroes.profile.presentation

import android.content.res.ColorStateList
import android.os.Handler
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityProfileBinding
import com.example.fundatecheroes.login.domain.LoginUseCase
import com.example.fundatecheroes.profile.presentation.model.ProfileViewState
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.launch

class ProfileViewModel: ViewModel() {

    private val useCase by lazy {
        LoginUseCase()
    }

    private val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()
    val state: LiveData<ProfileViewState> = viewState

    fun validacaoPreenchimento(
        name: String,
        email: String,
        password: String
    ) {
        if (name.isNullOrBlank() && email.isNullOrBlank() && password.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowNameEmailPasswordError
            return
        }
        else if (name.isNullOrBlank()){
            viewState.value = ProfileViewState.ShowNameError
            return
        }
        else if (email.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowEmailError
            return
        }
        else if (password.isNullOrBlank()) {
            viewState.value = ProfileViewState.ShowPasswordError
            return
        }
        else if (email.contains("@") && email.contains(".com")
        ) {
           viewModelScope.launch {
               val isSuccess = useCase.createUser(
                name = name,
                email = email,
                password = password,
            )
               if (isSuccess) {
                    viewState.value = ProfileViewState.ShowLoginScreen
               }
            }
        }
        else {
            viewState.value = ProfileViewState.ShowEmailError
        }
    }


}