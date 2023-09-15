package com.xnical.combigo.data.repository.dataSourceImpl

import com.xnical.combigo.data.repository.dataSource.AuthLocalDataSource
import com.xnical.combigo.data.datastore.AuthDatastore
import com.xnical.combigo.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow

class AuthLocalDataSourceImpl constructor(private val authDatastore: AuthDatastore):
    AuthLocalDataSource {

    override suspend fun saveSession(authResponse: AuthResponse) = authDatastore.save(authResponse)

    override fun getSessionData(): Flow<AuthResponse> = authDatastore.getData()

}