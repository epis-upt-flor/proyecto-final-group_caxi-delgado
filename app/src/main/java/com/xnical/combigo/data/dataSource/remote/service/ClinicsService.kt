package com.xnical.combigo.data.dataSource.remote.service

import com.xnical.combigo.domain.model.Clinic
import okhttp3.MultipartBody
import okhttp3.RequestBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path

interface ClinicsService {

    @GET("clinics")
    suspend fun getClinics(): Response<List<Clinic>>

    @Multipart
    @POST("clinics")
    suspend fun create(
        @Part file: MultipartBody.Part,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
    ): Response<Clinic>

    @PUT("clinics/{id}")
    suspend fun update(
        @Path("id") id: String,
        @Body clinic: Clinic
    ): Response<Clinic>

    @Multipart
    @PUT("clinics/upload/{id}")
    suspend fun updateWithImage(
        @Part file: MultipartBody.Part,
        @Path("id") id: String,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
    ): Response<Clinic>

    @DELETE("clinics/{id}")
    suspend fun delete(
        @Path("id") id: String,
    ): Response<Unit>

}