package com.xnical.combigo.data.dataSource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.xnical.combigo.data.dataSource.local.entity.ClinicEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ClinicsDao {

    // INSERT INTO clinics VALUES
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(clinic: ClinicEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(clinic: List<ClinicEntity>)

    @Query("SELECT * FROM clinics")
    fun getClinics(): Flow<List<ClinicEntity>>

    @Query("UPDATE clinics SET name = :name, description = :description, image = :image WHERE id = :id")
    suspend fun update(id: String, name: String, description: String, image: String)

    @Query("DELETE FROM clinics WHERE id = :id")
    suspend fun delete(id: String)

}