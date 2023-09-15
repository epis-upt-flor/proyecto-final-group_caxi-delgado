package com.xnical.combigo.domain.use_cases.auth

import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.repository.AuthRepository


class SaveSessionUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke(authResponse: AuthResponse) = repository.saveSession(authResponse)
}