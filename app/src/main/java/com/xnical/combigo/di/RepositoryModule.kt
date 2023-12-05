package com.xnical.combigo.di


import com.xnical.combigo.data.dataSource.local.AuthLocalDataSource
import com.xnical.combigo.data.dataSource.local.ClinicsLocalDataSource
import com.xnical.combigo.data.dataSource.remote.AuthRemoteDataSource
import com.xnical.combigo.data.repository.AuthRepositoryImpl
import com.xnical.combigo.data.repository.ClinicsRepositoryImpl
import com.xnical.combigo.data.repository.UsersRepositoryImpl
import com.xnical.combigo.data.dataSource.remote.ClinicsRemoteDataSource
import com.xnical.combigo.data.dataSource.remote.UsersRemoteDataSource
import com.xnical.combigo.domain.repository.AuthRepository
import com.xnical.combigo.domain.repository.ClinicsRepository
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
        authLocalDataSource: AuthLocalDataSource,
    ): AuthRepository = AuthRepositoryImpl(authRemoteDataSource, authLocalDataSource)

    @Provides
    fun provideUsersRepository(
        usersRemoteDataSource: UsersRemoteDataSource,
    ): UsersRepository = UsersRepositoryImpl(usersRemoteDataSource)

    @Provides
    fun provideClinicsRepository(
        clinicsRemoteDataSource: ClinicsRemoteDataSource,
        clinicsLocalDataSource: ClinicsLocalDataSource
    ): ClinicsRepository = ClinicsRepositoryImpl(clinicsRemoteDataSource, clinicsLocalDataSource)
}