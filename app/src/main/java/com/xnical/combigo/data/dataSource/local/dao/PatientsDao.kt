package com.xnical.combigo.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xnical.combigo.data.dataSource.local.entity.PatientEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface PatientsDao {

    // INSERT INTO clinics VALUES
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(patient: PatientEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(patient: List<PatientEntity>)

    @Query("SELECT * FROM patients")
    fun findAll(): Flow<List<PatientEntity>>

    @Query("SELECT * FROM patients WHERE id_clinic = :id_clinic ")
    fun findByClinic(id_clinic: String): Flow<List<PatientEntity>>

    @Query("UPDATE patients SET name = :name, description = :description, image1 = :image1, image2 = :image2, weight = :weight, age = :age WHERE id = :id")
    suspend fun update(id: String, name: String, description: String, image1: String, image2: String, weight: Double, age: Int)

    @Query("DELETE FROM patients WHERE id = :id")
    suspend fun delete(id: String)
}