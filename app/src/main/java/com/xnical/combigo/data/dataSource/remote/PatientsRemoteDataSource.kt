package com.xnical.combigo.data.dataSource.remote

import com.xnical.combigo.domain.model.Patient
import retrofit2.Response
import java.io.File

interface PatientsRemoteDataSource {
    suspend fun findAll(): Response<List<Patient>>
    suspend fun findByName(name: String): Response<List<Patient>>
    suspend fun findByClinic(idClinic: String): Response<List<Patient>>
    suspend fun create(patient: Patient, files: List<File>): Response<Patient>
    suspend fun updateWithImage(id: String, patient: Patient, files: List<File>?): Response<Patient>
    suspend fun update(id: String, product: Patient): Response<Patient>
    suspend fun delete(id: String): Response<Unit>
}