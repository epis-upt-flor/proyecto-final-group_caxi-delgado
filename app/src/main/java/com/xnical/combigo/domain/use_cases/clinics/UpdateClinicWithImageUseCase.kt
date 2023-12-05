package com.xnical.combigo.domain.use_cases.clinics

import com.xnical.combigo.domain.model.Clinic
import com.xnical.combigo.domain.repository.ClinicsRepository
import java.io.File

class UpdateClinicWithImageUseCase(private val repository: ClinicsRepository) {

    suspend operator fun invoke(id: String, clinic: Clinic, file: File) = repository.updateWithImage(id, clinic, file)
}