package com.xnical.combigo.di

import com.xnical.combigo.data.dataSource.remote.AuthRemoteDataSource
import com.xnical.combigo.data.dataSource.remote.ClinicsRemoteDataSource
import com.xnical.combigo.data.dataSource.remote.UsersRemoteDataSource
import com.xnical.combigo.data.dataSource.remote.AuthRemoteDataSourceImpl
import com.xnical.combigo.data.dataSource.remote.ClinicsRemoteDataSourceImpl
import com.xnical.combigo.data.dataSource.remote.PatientsRemoteDataSource
import com.xnical.combigo.data.dataSource.remote.PatientsRemoteDataSourceImpl
import com.xnical.combigo.data.dataSource.remote.UsersRemoteDataSourceImpl
import com.xnical.combigo.data.dataSource.remote.service.AuthService
import com.xnical.combigo.data.dataSource.remote.service.ClinicsService
import com.xnical.combigo.data.dataSource.remote.service.PatientsService
import com.xnical.combigo.data.dataSource.remote.service.UsersService
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

    @Provides
    fun provideClinicsRemoteDataSource(clinicsService: ClinicsService): ClinicsRemoteDataSource = ClinicsRemoteDataSourceImpl(clinicsService)

    @Provides
    fun providePatientsRemoteDataSource(patientsService: PatientsService): PatientsRemoteDataSource = PatientsRemoteDataSourceImpl(patientsService)
}