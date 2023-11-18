package com.xnical.combigo.domain.repository

import com.xnical.combigo.domain.model.User
import com.xnical.combigo.domain.util.Resource
import java.io.File

interface UsersRepository {
    suspend fun update(id: String, user: User): Resource<User>
    suspend fun updateWithImage(id: String, user: User, file: File): Resource<User>
}