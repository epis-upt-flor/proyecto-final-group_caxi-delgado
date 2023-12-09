package com.xnical.combigo.domain.repository

import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.util.Resource
import kotlinx.coroutines.flow.Flow
import java.io.File

interface PatientsRepository {
    fun findAll(): Flow<Resource<List<Patient>>>
    fun findByClinic(idClinic: String): Flow<Resource<List<Patient>>>
    fun findByName(name: String): Flow<Resource<List<Patient>>>
    suspend fun create(patient: Patient, files: List<File>): Resource<Patient>
    suspend fun updateWithImage(id: String, patient: Patient, files: List<File>?): Resource<Patient>
    suspend fun update(id: String, patient: Patient): Resource<Patient>
    suspend fun delete(id: String): Resource<Unit>
}