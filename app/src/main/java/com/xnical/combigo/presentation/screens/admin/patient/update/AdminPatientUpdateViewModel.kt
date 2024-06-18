package com.xnical.combigo.presentation.screens.admin.patient.update

import android.content.Context
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.use_cases.patients.PatientsUseCase
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.presentation.screens.admin.patient.create.mapper.toPatient
import com.xnical.combigo.presentation.screens.admin.patient.update.mapper.toPatient
import com.xnical.combigo.presentation.util.ComposeFileProvider
import com.xnical.combigo.presentation.util.ResultingActivityHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.launch
import java.io.File
import javax.inject.Inject

@HiltViewModel
class AdminPatientUpdateViewModel @Inject constructor(
    @ApplicationContext val context: Context,
    private val savedStateHandle: SavedStateHandle,
    private val patientsUseCase: PatientsUseCase
): ViewModel() {

    var state by mutableStateOf(AdminPatientUpdateState())
        private set

    var patientResponse by mutableStateOf<Resource<Patient>?>(null)
        private set

    var data = savedStateHandle.get<String>("patient")
    var patient = Patient.fromJson(data!!)

    // IMAGENES
    var file1: File? = null
    var file2: File? = null
    var files: MutableList<File> = mutableListOf()
    val resultingActivityHandler = ResultingActivityHandler()

    init {
        state = state.copy(
            name = patient.name,
            description = patient.description,
            weight = patient.weight,
            age = patient.age,
            idClinic = patient.idClinic,
            image1 = patient.image1 ?: "",
            image2 = patient.image2 ?: "",
        )
    }

    fun updatePatient() = viewModelScope.launch {
        patientResponse = Resource.Loading
        if (file1 == null && file2 == null) {

            val result = patientsUseCase.updatePatient(patient.id!!, state.toPatient())
            patientResponse = result
        }
        else {
            if (file1 != null) {
                files.add(file1!!)
                state.imagesToUpdate.add(0)
            }
            if (file2 != null) {
                files.add(file2!!)
                state.imagesToUpdate.add(1)
            }

            val result = patientsUseCase.updatePatientWithImage(patient.id!!, state.toPatient(), files.toList())
            patientResponse = result
        }
        files.clear()
        file1 = null
        file2 = null
        state.imagesToUpdate.clear()
    }

    fun pickImage(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.getContent("image/*") // URI
        if (result != null) {
            if (imageNumber == 1) {
                file1 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image1 = result.toString())
            }
            else if (imageNumber == 2) {
                file2 = ComposeFileProvider.createFileFromUri(context, result)
                state = state.copy(image2 = result.toString())
            }
        }
    }

    fun takePhoto(imageNumber: Int) = viewModelScope.launch {
        val result = resultingActivityHandler.takePicturePreview()
        if (result != null) {
            if (imageNumber == 1) {
                state = state.copy(image1 = ComposeFileProvider.getPathFromBitmap(context, result))
                file1 = File(state.image1)
            }
            else if (imageNumber == 2) {
                state = state.copy(image2 = ComposeFileProvider.getPathFromBitmap(context, result))
                file2 = File(state.image2)
            }
        }
    }


    fun onNameInput(input: String) {
        state = state.copy(name = input)
    }

    fun onDescriptionInput(input: String) {
        state = state.copy(description = input)
    }

    fun onWeightInput(input: String) {
        state = state.copy(weight = input.toDouble())
    }

    fun onAgeInput(input: String) {
        state = state.copy(age = input.toInt())
    }

}