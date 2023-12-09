package com.xnical.combigo.data.dataSource.remote

import com.xnical.combigo.data.dataSource.remote.service.PatientsService
import com.xnical.combigo.domain.model.Patient
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class PatientsRemoteDataSourceImpl(private val patientsService: PatientsService): PatientsRemoteDataSource {
    override suspend fun findAll(): Response<List<Patient>> {
        TODO("Not yet implemented")
    }

    override suspend fun findByName(name: String): Response<List<Patient>> {
        TODO("Not yet implemented")
    }

    override suspend fun findByClinic(idClinic: String): Response<List<Patient>> {
        TODO("Not yet implemented")
    }

    override suspend fun create(patient: Patient, files: List<File>): Response<Patient> {
        val images = arrayOfNulls<MultipartBody.Part>(files.size)
        val contentType = "text/plain"

        files.forEachIndexed { index, file ->
            val connection = file.toURI().toURL().openConnection()
            val mimeType = connection.contentType // "image/png | image/jpg"
            val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
            images[index] = MultipartBody.Part.createFormData("files[]", file.name, requestFile)
        }

        val nameData = patient.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = patient.description.toRequestBody(contentType.toMediaTypeOrNull())
        val idClinicData = patient.idClinic.toRequestBody(contentType.toMediaTypeOrNull())
        val weightData = patient.weight.toString().toRequestBody(contentType.toMediaTypeOrNull())
        val ageData = patient.age.toString().toRequestBody(contentType.toMediaTypeOrNull())

        return patientsService.create(images, nameData, descriptionData, idClinicData, weightData, ageData)
    }

    override suspend fun updateWithImage(
        id: String,
        patient: Patient,
        files: List<File>?
    ): Response<Patient> {
        TODO("Not yet implemented")
    }

    override suspend fun update(id: String, product: Patient): Response<Patient> {
        TODO("Not yet implemented")
    }

    override suspend fun delete(id: String): Response<Unit> {
        TODO("Not yet implemented")
    }

}