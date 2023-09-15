package com.xnical.combigo.data.repository.dataSourceImpl

import com.xnical.combigo.data.repository.dataSource.AuthRemoteDataSource
import com.xnical.combigo.data.service.AuthService
import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.model.User
import retrofit2.Response

//IMPLEMENTA LA INTERFAZ "AUTHREMOTEDATASOURCE" QUE SE UTILIZA PARA INTERACTUAR CON LA API
// authService : INSTANCIA DE LA CLASE "AUTHSERVICE" QUE PROPORCIONA FUNCIONES PARA REALIZAR SOLICITUDES HTTP CON RETROFIT
class AuthRemoteDataSourceImpl(private val authService: AuthService): AuthRemoteDataSource {

    override suspend fun login(email: String, password: String) = authService.login(email, password)
    override suspend fun register(user: User): Response<AuthResponse> = authService.register(user)

}