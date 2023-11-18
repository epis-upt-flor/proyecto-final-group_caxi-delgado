package com.xnical.combigo.domain.use_cases.auth

import com.xnical.combigo.domain.model.AuthResponse
import com.xnical.combigo.domain.repository.AuthRepository


class LogoutUseCase constructor(private val repository: AuthRepository) {
    suspend operator fun invoke() = repository.logout()
}