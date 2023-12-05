package com.xnical.combigo.data.repository

import android.util.Log
import com.xnical.combigo.data.dataSource.local.ClinicsLocalDataSource
import com.xnical.combigo.data.dataSource.local.entity.ClinicEntity
import com.xnical.combigo.data.dataSource.remote.ClinicsRemoteDataSource
import com.xnical.combigo.data.mapper.toClinic
import com.xnical.combigo.data.mapper.toClinicEntity
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.repository.ClinicsRepository
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.domain.util.ResponseToRequest
import com.xnical.combigo.domain.util.isListEqual
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import java.io.File

class ClinicsRepositoryImpl(
    private val remoteDataSource: ClinicsRemoteDataSource,
    private val localDataSource: ClinicsLocalDataSource
): ClinicsRepository {
    override suspend fun create(clinic: Clinic, file:File): Resource<Clinic> {
        ResponseToRequest.send(remoteDataSource.create(clinic, file)).run {
            return when(this){
                is Resource.Success -> {
                    localDataSource.create(this.data.toClinicEntity())
                    Resource.Success(this.data)
                }
                else -> {
                    Resource.Failure("Error desconocido")
                }
            }
        }
    }


    override fun getClinics(): Flow<Resource<List<Clinic>>> = flow {
        localDataSource.getClinics().collect() {
           it.run {
               //if (this.isNotEmpty()){
               //    Log.d("ClinicsRepositoryImpl", "Data Local: ${this}")
               //    emit(Resource.Success(this.map { clinicEntity -> clinicEntity.toClinic() }))
               //}
               val clinicsLocalMap = this.map{ clinicEntity -> clinicEntity.toClinic() }
               try {
                   ResponseToRequest.send(remoteDataSource.getClinic()).run {
                       when(this){
                           is Resource.Success ->{
                               val clinicsRemote = this.data

                               if(!isListEqual(clinicsRemote, clinicsLocalMap)){
                                   localDataSource.insertAll(clinicsRemote.map { clinic -> clinic.toClinicEntity() })
                               }

                               emit(Resource.Success(clinicsRemote))
                           }
                           is Resource.Failure -> {
                               emit(Resource.Success(clinicsLocalMap))
                           }
                           else -> {
                               emit(Resource.Success(clinicsLocalMap))
                           }
                       }
                   }
               } catch (e: Exception) {
                   emit(Resource.Success(clinicsLocalMap))
               }

           }
        }
    }.flowOn(Dispatchers.IO)

    override suspend fun update(id: String, clinic: Clinic): Resource<Clinic> {

        ResponseToRequest.send(remoteDataSource.update(id, clinic)).run {
            return when(this){
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
                    )
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
        clinic: Clinic,
        file: File
    ): Resource<Clinic> {
        ResponseToRequest.send(remoteDataSource.updateWithImage(id, clinic, file)).run {
            return when(this){
                is Resource.Success -> {
                    localDataSource.update(
                        id = this.data.id ?: "",
                        name = this.data.name,
                        description = this.data.description,
                        image = this.data.image ?: ""
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
        ResponseToRequest.send(remoteDataSource.delete(id)).run {
            return when(this){
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