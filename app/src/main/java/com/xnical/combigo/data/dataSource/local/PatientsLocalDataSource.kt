package com.xnical.combigo.data.dataSource.local

import com.xnical.combigo.data.dataSource.local.entity.PatientEntity
import kotlinx.coroutines.flow.Flow

interface PatientsLocalDataSource {

    suspend fun insert(patient: PatientEntity)
    suspend fun insertAll(patients: List<PatientEntity>)
    fun findAll(): Flow<List<PatientEntity>>
    fun findByClinic(idClinic: String): Flow<List<PatientEntity>>
    suspend fun update(id: String, name: String, description: String, image1: String, image2: String, weight: Double, age: Int)
    suspend fun delete(id: String)
}