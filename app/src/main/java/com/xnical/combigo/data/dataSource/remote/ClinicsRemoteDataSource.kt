package com.xnical.combigo.data.dataSource.remote

import com.xnical.combigo.domain.model.Clinic
import retrofit2.Response
import java.io.File

interface ClinicsRemoteDataSource {

    suspend fun create(clinic: Clinic, file: File): Response<Clinic>
    suspend fun getClinic(): Response<List<Clinic>>
    suspend fun update(id: String, clinic: Clinic): Response<Clinic>
    suspend fun updateWithImage(id: String, clinic: Clinic, file: File): Response<Clinic>
    suspend fun delete(id: String): Response<Unit>

}