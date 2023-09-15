package com.xnical.combigo.data.datastore

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import com.xnical.combigo.core.Config.AUTH_KEY
import com.xnical.combigo.domain.model.AuthResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AuthDatastore constructor(private val dataStore: DataStore<Preferences>) {
    // Guarda los datos de la respuesta de autenticación en el DataStore.
    suspend fun save(authResponse: AuthResponse) {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        dataStore.edit { pref ->
            pref[dataStoreKey] = authResponse.toJson()
        }
    }

    // Obtiene los datos de autenticación guardados en el DataStore como un flujo.
    fun getData(): Flow<AuthResponse> {
        val dataStoreKey = stringPreferencesKey(AUTH_KEY)
        return dataStore.data.map { pref ->
            if (pref[dataStoreKey] != null) {
                AuthResponse.fromJson(pref[dataStoreKey]!!)
            }
            else {
                AuthResponse() // Devuelve una AuthResponse vacía si no se encuentran datos en el DataStore.
            }
        }
    }

}