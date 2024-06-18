package com.xnical.combigo.domain.use_cases.patients

import com.xnical.combigo.domain.repository.PatientsRepository

class FindByNameUseCase(private val repository: PatientsRepository) {
    suspend operator fun invoke(name: String) = repository.findByName(name)
}