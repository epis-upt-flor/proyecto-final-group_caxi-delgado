package com.xnical.combigo.domain.use_cases.users

import com.xnical.combigo.domain.model.User
import com.xnical.combigo.domain.repository.UsersRepository

class UpdateUserUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User) = repository.update(id, user)

}