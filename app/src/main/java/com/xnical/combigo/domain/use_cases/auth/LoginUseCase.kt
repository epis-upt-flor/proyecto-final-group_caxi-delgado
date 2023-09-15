package com.xnical.combigo.domain.use_cases.auth

import com.xnical.combigo.domain.repository.AuthRepository


class LoginUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(email: String, password: String) = repository.login(email, password)

}