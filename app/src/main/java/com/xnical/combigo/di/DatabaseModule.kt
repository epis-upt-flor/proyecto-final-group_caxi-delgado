package com.xnical.combigo.di

import android.app.Application
import androidx.room.Room
import com.xnical.combigo.data.dataSource.local.dao.ClinicsDao
import com.xnical.combigo.data.dataSource.local.db.AppDB
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(app: Application): AppDB =
        Room.databaseBuilder(app, AppDB::class.java, "api_db").fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideClinicsDao(db: AppDB): ClinicsDao = db.clinicsDao()
}