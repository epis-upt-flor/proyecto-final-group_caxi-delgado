package com.xnical.combigo.data.dataSource.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.xnical.combigo.data.dataSource.local.dao.ClinicsDao
import com.xnical.combigo.data.dataSource.local.dao.PatientsDao
import com.xnical.combigo.data.dataSource.local.entity.ClinicEntity
import com.xnical.combigo.data.dataSource.local.entity.PatientEntity

@Database(
    entities = [ClinicEntity::class, PatientEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDB: RoomDatabase() {
    abstract fun clinicsDao(): ClinicsDao // DATA ACCESS OBJECT
    abstract fun patientsDao(): PatientsDao
}