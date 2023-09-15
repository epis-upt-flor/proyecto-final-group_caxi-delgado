package com.xnical.combigo.domain.use_cases.auth

import com.xnical.combigo.domain.repository.AuthRepository

class GetSessionDataUseCase constructor(private val repository: AuthRepository) {
    operator fun invoke() = repository.getSessionData()
}