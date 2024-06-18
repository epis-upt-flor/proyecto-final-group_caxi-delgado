package com.xnical.combigo.domain.use_cases.patients

import com.xnical.combigo.domain.model.Patient
import com.xnical.combigo.domain.repository.PatientsRepository

class DeletePatientUseCase(private val repository: PatientsRepository) {
    suspend operator fun invoke(id: String) = repository.delete(id)
}