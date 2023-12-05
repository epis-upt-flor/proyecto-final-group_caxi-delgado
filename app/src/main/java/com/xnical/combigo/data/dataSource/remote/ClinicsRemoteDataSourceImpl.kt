package com.xnical.combigo.data.dataSource.remote


import com.xnical.combigo.data.dataSource.remote.ClinicsRemoteDataSource
import com.xnical.combigo.data.dataSource.remote.service.ClinicsService
import com.xnical.combigo.domain.model.Clinic
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import retrofit2.Response
import java.io.File

class ClinicsRemoteDataSourceImpl(private val clinicsService: ClinicsService):
    ClinicsRemoteDataSource {

    override suspend fun create(clinic: Clinic, file: File): Response<Clinic> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType // "image/png | image/jpg"
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = clinic.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = clinic.description.toRequestBody(contentType.toMediaTypeOrNull())

        return clinicsService.create(fileFormData, nameData, descriptionData)
    }

    override suspend fun getClinic(): Response<List<Clinic>> = clinicsService.getClinics()

    override suspend fun update(id: String, clinic: Clinic): Response<Clinic> = clinicsService.update(id, clinic)

    override suspend fun updateWithImage(
        id: String,
        clinic: Clinic,
        file: File
    ): Response<Clinic> {
        val connection = file.toURI().toURL().openConnection()
        val mimeType = connection.contentType // "image/png | image/jpg"
        val contentType = "text/plain"
        val requestFile = file.asRequestBody(mimeType.toMediaTypeOrNull())
        val fileFormData = MultipartBody.Part.createFormData("file", file.name, requestFile)
        val nameData = clinic.name.toRequestBody(contentType.toMediaTypeOrNull())
        val descriptionData = clinic.description.toRequestBody(contentType.toMediaTypeOrNull())

        return clinicsService.updateWithImage(fileFormData, id, nameData, descriptionData)
    }

    override suspend fun delete(id: String): Response<Unit> = clinicsService.delete(id)

}