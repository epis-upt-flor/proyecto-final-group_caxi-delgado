package com.xnical.combigo.domain.use_cases.users

import com.xnical.combigo.domain.model.User
import com.xnical.combigo.domain.repository.UsersRepository
import java.io.File

class UpdateUserWithImageUseCase(private val repository: UsersRepository) {

    suspend operator fun invoke(id: String, user: User, file: File) = repository.updateWithImage(id, user, file)

}