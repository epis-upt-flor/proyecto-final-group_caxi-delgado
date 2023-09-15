package com.xnical.combigo.data.service

import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.model.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST

//SE DEFINEN FUNCIONES PARA REALIZAR SOLICITUDES DE AUTHENTICATION EN UNA API
interface AuthService {

    // http://192.168.1.15:3000/auth/login
    @FormUrlEncoded
    @POST("auth/login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String,
    ): Response<AuthResponse>

    @POST("auth/register")
    suspend fun register(
        @Body() user: User,
    ): Response<AuthResponse>

}