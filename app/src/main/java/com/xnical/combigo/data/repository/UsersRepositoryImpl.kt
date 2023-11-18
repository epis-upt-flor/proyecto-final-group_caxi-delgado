package com.xnical.combigo.data.repository

import com.xnical.combigo.data.repository.dataSource.UsersRemoteDataSource
import com.xnical.combigo.domain.model.User
import com.xnical.combigo.domain.repository.UsersRepository
import com.xnical.combigo.domain.util.Resource
import com.xnical.combigo.domain.util.ResponseToRequest
import java.io.File

class UsersRepositoryImpl(
    private val usersRemoteDataSource: UsersRemoteDataSource,
): UsersRepository {

    override suspend fun update(id: String, user: User): Resource<User> = ResponseToRequest.send(
        usersRemoteDataSource.update(id, user)
    )

    override suspend fun updateWithImage(id: String, user: User, file: File) = ResponseToRequest.send(
        usersRemoteDataSource.updateWithImage(id, user, file)
    )

}