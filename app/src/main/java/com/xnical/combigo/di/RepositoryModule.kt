package com.xnical.combigo.di


import com.xnical.combigo.data.repository.dataSource.AuthLocalDataSource
import com.xnical.combigo.data.repository.dataSource.AuthRemoteDataSource
import com.xnical.combigo.data.repository.AuthRepositoryImpl
import com.xnical.combigo.data.repository.UsersRepositoryImpl
import com.xnical.combigo.data.repository.dataSource.UsersRemoteDataSource
import com.xnical.combigo.domain.repository.AuthRepository
import com.xnical.combigo.domain.repository.UsersRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun provideAuthRepository(
        authRemoteDataSource: AuthRemoteDataSource,
        authLocalDataSource: AuthLocalDataSource
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)
}