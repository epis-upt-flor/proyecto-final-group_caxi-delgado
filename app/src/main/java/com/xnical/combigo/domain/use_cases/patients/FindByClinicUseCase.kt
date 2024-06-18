package com.xnical.combigo.domain.use_cases.patients

import com.xnical.combigo.domain.repository.PatientsRepository

class FindByClinicUseCase(private val repository: PatientsRepository) {
    suspend operator fun invoke(idClinic: String) = repository.findByClinic(idClinic)
}