package com.xnical.combigo.domain.use_cases.patients

import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.repository.PatientsRepository

class UpdatePatientUseCase(private val repository: PatientsRepository) {
    suspend operator fun invoke(id: String, patient: Patient) = repository.update(id, patient)
}