package com.xnical.combigo.domain.repository

import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface ClinicsRepository {

    suspend fun create(clinic: Clinic, file: File): Resource<Clinic>
    fun getClinics(): Flow<Resource<List<Clinic>>>
    suspend fun update(id: String, clinic:Clinic): Resource<Clinic>
    suspend fun updateWithImage(id:String, clinic: Clinic, file: File): Resource<Clinic>
    suspend fun delete(id:String): Resource<Unit>
}