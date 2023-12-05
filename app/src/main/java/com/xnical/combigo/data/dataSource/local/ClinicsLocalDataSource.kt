package com.xnical.combigo.data.dataSource.local

import com.xnical.combigo.data.dataSource.local.entity.ClinicEntity
import kotlinx.coroutines.flow.Flow

interface ClinicsLocalDataSource {
    suspend fun create(clinic: ClinicEntity)
    suspend fun insertAll(clinics: List<ClinicEntity>)
    fun getClinics(): Flow<List<ClinicEntity>>
    suspend fun update(id: String, name: String, description: String, image: String)
    suspend fun delete(id: String)
}