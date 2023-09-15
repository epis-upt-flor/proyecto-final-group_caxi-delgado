package com.xnical.combigo.domain.use_cases.auth

import com.xnical.combigo.domain.model.User
import com.xnical.combigo.domain.repository.AuthRepository


class RegisterUseCase(private val repository: AuthRepository) {

    suspend operator fun invoke(user: User) =  repository.register(user);

}