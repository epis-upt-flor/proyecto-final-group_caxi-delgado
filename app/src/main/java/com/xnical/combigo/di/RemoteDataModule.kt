package com.xnical.combigo.di

import com.xnical.combigo.data.repository.dataSource.AuthRemoteDataSource
import com.xnical.combigo.data.repository.dataSource.UsersRemoteDataSource
import com.xnical.combigo.data.repository.dataSourceImpl.AuthRemoteDataSourceImpl
import com.xnical.combigo.data.repository.dataSourceImpl.UsersRemoteDataSourceImpl
import com.xnical.combigo.data.service.AuthService
import com.xnical.combigo.data.service.UsersService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

//INYECTA LA IMPLEMENTACION AUTHREMOTEDATASOURCEIMPL EN CUALQUIER PARTE DE LA APLICACION QUE NECESITE UNA INSTANCIA DE AUTHREMOTEDATASOURCE
@Module
@InstallIn(SingletonComponent::class)
object RemoteDataModule {
    @Provides
    fun provideAuthRemoteDataSource(authService: AuthService): AuthRemoteDataSource = AuthRemoteDataSourceImpl(authService)

    @Provides
    fun provideUsersRemoteDataSource(usersService: UsersService): UsersRemoteDataSource = UsersRemoteDataSourceImpl(usersService)
}