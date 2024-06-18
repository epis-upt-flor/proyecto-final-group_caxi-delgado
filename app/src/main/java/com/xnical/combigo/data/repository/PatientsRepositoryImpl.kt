package com.xnical.combigo.data.repository

import com.xnical.combigo.data.dataSource.local.PatientsLocalDataSource
import com.xnical.combigo.data.dataSource.remote.PatientsRemoteDataSource
import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.repository.PatientsRepository
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.domain.util.ResponseToRequest
import com.xnical.combigo.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import toPatient
import toPatientEntity
import java.io.File

class PatientsRepositoryImpl(
    private val remoteDataSource: PatientsRemoteDataSource,
    private val localDataSource: PatientsLocalDataSource
): PatientsRepository {
    override fun findAll(): Flow<Resource<List<Patient>>> = flow {
        localDataSource.findAll().collect() {
            it.run {
                val patientsLocalMap = this.map { patientEntity -> patientEntity.toPatient()  }
                try {
                    ResponseToRequest.send(remoteDataSource.findAll()).run {
                        when(this) {
                            is Resource.Success -> {
                                val patientsRemote = this.data

                                if (!isListEqual(patientsRemote, patientsLocalMap)) {
                                    localDataSource.insertAll(patientsRemote.map { patient -> patient.toPatientEntity() })
                                }

                                emit(Resource.Success(patientsRemote))
                            }
                            else -> {
                                emit(Resource.Success(patientsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(patientsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override fun findByClinic(idClinic: String): Flow<Resource<List<Patient>>> = flow {
        localDataSource.findByClinic(idClinic).collect() {
            it.run {
                val patientsLocalMap = this.map { patientEntity -> patientEntity.toPatient()  }
                try {
                    ResponseToRequest.send(remoteDataSource.findByClinic(idClinic)).run {
                        when(this) {
                            is Resource.Success -> {
                                val patientsRemote = this.data

                                if (!isListEqual(patientsRemote, patientsLocalMap)) {
                                    localDataSource.insertAll(patientsRemote.map { patient -> patient.toPatientEntity() })
                                }

                                emit(Resource.Success(patientsRemote))
                            }
                            else -> {
                                emit(Resource.Success(patientsLocalMap))
                            }
                        }
                    }
                } catch (e: Exception) {
                    emit(Resource.Success(patientsLocalMap))
                }
            }
        }
    }.flowOn(Dispatchers.IO)

    override fun findByName(name: String): Flow<Resource<List<Patient>>> = flow {
        emit(ResponseToRequest.send(remoteDataSource.findByName(name)))
    }

    override suspend fun create(patient: Patient, files: List<File>): Resource<Patient> {

        ResponseToRequest.send(remoteDataSource.create(patient, files)).run{
            return when(this) {
                is Resource.Success -> {
                    localDataSource.insert(this.data.toPatientEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

    override suspend fun updateWithImage(
        id: String,
        patient: Patient,
        files: List<File>?
    ): Resource<Patient> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, patient, files)).run {
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "",
                        image2 = this.data.image2 ?: "",
                        weight = this.data.weight,
                        age = this.data.age,
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }


    override suspend fun update(id: String, patient: Patient): Resource<Patient>{
        ResponseToRequest.send(remoteDataSource.update(id, patient)).run{
            return when(this) {
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image1 = this.data.image1 ?: "",
                        image2 = this.data.image2 ?: "",
                        weight = this.data.weight,
                        age = this.data.age,
                    )
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }

        }
    }

    override suspend fun delete(id: String): Resource<Unit> {
        ResponseToRequest.send(remoteDataSource.delete(id)).run{
            return when(this) {
                is Resource.Success -> {
                    localDataSource.delete(id)
                    Resource.Success(Unit)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }

}