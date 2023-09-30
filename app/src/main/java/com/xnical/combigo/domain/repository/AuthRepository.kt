package com.xnical.combigo.domain.repository

import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.model.User
import com.xnical.combigo.domain.util.Resource
import kotlinx.coroutines.flow.Flow

//Define metodos que gestion la authentication y register
interface AuthRepository {
    suspend fun login(email: String, password: String): Resource<AuthResponse>
    suspend fun register(user: User):  Resource<AuthResponse>
    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>
}