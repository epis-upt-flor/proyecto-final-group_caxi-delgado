package com.xnical.combigo.data.dataSource.local

import com.xnical.combigo.data.dataSource.local.dao.ClinicsDao
import com.xnical.combigo.data.dataSource.local.entity.ClinicEntity
import kotlinx.coroutines.flow.Flow

class ClinicsLocalDataSourceImpl(private val clinicsDao: ClinicsDao): ClinicsLocalDataSource {
    override suspend fun create(clinic: ClinicEntity) = clinicsDao.insert(clinic)

    override suspend fun insertAll(clinics: List<ClinicEntity>) = clinicsDao.insertAll(clinics)

    override fun getClinics(): Flow<List<ClinicEntity>> = clinicsDao.getClinics()

    override suspend fun update(id: String, name: String, description: String, image: String) =
        clinicsDao.update(id, name, description, image)

    override suspend fun delete(id: String) = clinicsDao.delete(id)

}