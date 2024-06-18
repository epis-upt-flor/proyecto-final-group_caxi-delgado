package com.xnical.combigo.domain.use_cases.patients

import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.repository.PatientsRepository
import java.io.File

class UpdatePatientWithImageUseCase(private val repository: PatientsRepository) {
    suspend operator fun invoke(id: String, patient: Patient, files: List<File>) = repository.updateWithImage(id, patient, files)
}