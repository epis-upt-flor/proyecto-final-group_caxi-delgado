package com.xnical.combigo.data.dataSource.remote

import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.model.User
import retrofit2.Response

//DEFINE FUNCIONES PARA REALIZAR SOLICITUDES DE AUTHENTICATION Y REGISTRO A UN SERVIDOR REMOTO(API)
interface AuthRemoteDataSource {
// AuthResponse : REPRESENTA LOS DATOS DEL RESULTADO.
    suspend fun login(email: String, password: String): Response<AuthResponse>
    suspend fun register(user: User): Response<AuthResponse>

}