package com.xnical.combigo.presentation.screens.roles

import android.util.Log
import androidx.compose.runtime.*
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.use_cases.auth.AuthUseCase
import com.xnical.combigo.domain.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RolesViewModel @Inject constructor(private val authUseCase : AuthUseCase) : ViewModel() {

    var authResponse by mutableStateOf(AuthResponse())

    init {
        getSessionData()
    }

    fun getSessionData() = viewModelScope.launch {
        authUseCase.getSessionData().collect() { data ->
            //Log.d("LoginViewModel", "Data: ${data.toJson()}")
            if (!data.token.isNullOrBlank()) {
                authResponse = data
            }
        }
    }

}