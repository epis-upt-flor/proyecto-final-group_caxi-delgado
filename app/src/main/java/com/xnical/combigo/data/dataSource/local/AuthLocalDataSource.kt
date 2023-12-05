package com.xnical.combigo.data.dataSource.local

import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthLocalDataSource {

    suspend fun saveSession(authResponse: AuthResponse)
    suspend fun updateSession(user: User)
    suspend fun logout()
    fun getSessionData(): Flow<AuthResponse>

}