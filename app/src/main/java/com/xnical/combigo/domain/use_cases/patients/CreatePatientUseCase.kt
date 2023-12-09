package com.xnical.combigo.domain.use_cases.patients

import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.repository.PatientsRepository
import java.io.File

class CreatePatientUseCase(private val repository: PatientsRepository) {

    suspend operator fun invoke(patient: Patient, files: List<File>) = repository.create(patient, files)
}