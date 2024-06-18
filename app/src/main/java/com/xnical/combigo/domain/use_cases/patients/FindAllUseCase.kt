package com.xnical.combigo.domain.use_cases.patients

import com.xnical.combigo.domain.repository.PatientsRepository

class FindAllUseCase(private val repository: PatientsRepository) {
    suspend operator fun invoke() = repository.findAll()
}