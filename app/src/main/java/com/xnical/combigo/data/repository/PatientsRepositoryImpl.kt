package com.xnical.combigo.data.repository

import com.xnical.combigo.data.dataSource.remote.PatientsRemoteDataSource
import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.repository.PatientsRepository
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.domain.util.ResponseToRequest
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.File

class PatientsRepositoryImpl(private val remoteDataSource: PatientsRemoteDataSource): PatientsRepository {
    override fun findAll(): Flow<Resource<List<Patient>>> {
        TODO("Not yet implemented")
    }

    override fun findByClinic(idClinic: String): Flow<Resource<List<Patient>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByClinic(idClinic)))
    }

    override fun findByName(name: String): Flow<Resource<List<Patient>>> {
        TODO("Not yet implemented")
    }

    override suspend fun create(patient: Patient, files: List<File>): Resource<Patient> = ResponseToRequest.send(
        remoteDataSource.create(patient, files)
    )

    override suspend fun updateWithImage(
        id: String,
        patient: Patient,
        files: List<File>?
    ): Resource<Patient> {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: String, patient: Patient): Resource<Patient> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Resource<Unit> {
        TODO("Not yet implemented")
    }
}