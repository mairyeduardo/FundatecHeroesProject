package com.example.fundatecheroes.profile.presentation

import android.content.res.ColorStateList
import android.os.Handler
import android.widget.EditText
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fundatecheroes.R
import com.example.fundatecheroes.databinding.ActivityProfileBinding
import com.example.fundatecheroes.profile.presentation.model.ProfileViewState
import com.google.android.material.snackbar.Snackbar

class ProfileViewModel: ViewModel() {

    private val viewState: MutableLiveData<ProfileViewState> = MutableLiveData()
    val state: LiveData<ProfileViewState> = viewState

    fun validacaoPreenchimento(
        editText: String,
        editText2: String,
        editText3: String
    ) {

        if (editText.isEmpty() || editText2.isEmpty() || editText3.isEmpty()) {
            viewState.value = ProfileViewState.ShowEmailPasswordError
        } else if (editText2.contains("@") && editText2.contains(".com")
        ) {
            viewState.value = ProfileViewState.ShowHomeScreen
        } else {
            viewState.value = ProfileViewState.ShowEmailError
        }
    }


}