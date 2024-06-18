package com.xnical.combigo.data.dataSource.local

import com.xnical.combigo.data.dataSource.local.dao.PatientsDao
import com.xnical.combigo.data.dataSource.local.entity.PatientEntity
import kotlinx.coroutines.flow.Flow

class PatientsLocalDataSourceImpl(private val patientsDao: PatientsDao): PatientsLocalDataSource {

    override suspend fun insert(patient: PatientEntity) = patientsDao.insert(patient)

    override suspend fun insertAll(patients: List<PatientEntity>) = patientsDao.insertAll(patients)

    override fun findAll(): Flow<List<PatientEntity>> = patientsDao.findAll()

    override fun findByClinic(idClinic: String): Flow<List<PatientEntity>> = patientsDao.findByClinic(idClinic)

    override suspend fun update(
        id: String,
        name: String,
        description: String,
        image1: String,
        image2: String,
        weight: Double,
        age: Int
    ) = patientsDao.update(id, name, description, image1, image2, weight, age)

    override suspend fun delete(id: String) = patientsDao.delete(id)

}