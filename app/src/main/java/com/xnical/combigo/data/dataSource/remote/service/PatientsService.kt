package com.xnical.combigo.data.dataSource.remote.service

import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.model.Patient
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

interface PatientsService {

    @GET("patients/clinic/{id_clinic}")
    suspend fun findByClinic(
        @Path("id_clinic") idClinic: String
    ): Response<List<Patient>>

    //@GET("patients")
    //suspend fun findAll(): Response<List<Patient>>

    @Multipart
    @POST("patients")
    suspend fun create(
        @Part files: Array<MultipartBody.Part?>,
        @Part("name") name: RequestBody,
        @Part("description") description: RequestBody,
        @Part("id_clinic") idClinic: RequestBody,
        @Part("weight") weight: RequestBody,
        @Part("age") age: RequestBody
    ): Response<Patient>

//    @Multipart
//    @PUT("patients/upload/{id}")
//    suspend fun updateWithImage(
//        @Part files: Array<MultipartBody.Part?>,
//        @Path("id") id: String,
//        @Part("name") name: RequestBody,
//        @Part("description") description: RequestBody,
//        @Part("id_category") idCategory: RequestBody,
//        @Part("price") price: RequestBody,
//        @Part("images_to_update[]") imagesToUpdate: Array<RequestBody?>,
//    ): Response<Patient>
//
//    @PUT("patients/{id}")
//    suspend fun update(
//        @Path("id") id: String,
//        @Body patient: Patient
//    ): Response<Patient>
//
//    @DELETE("patients/{id}")
//    suspend fun delete(
//        @Path("id") id: String,
//    ): Response<Unit>

}