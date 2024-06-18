package com.xnical.combigo.data.dataSource.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "patients")
data class PatientEntity(
    @PrimaryKey var id: String = "",
    @ColumnInfo("name") var name: String = "",
    @ColumnInfo("description") var description: String = "",
    @ColumnInfo("id_clinic") var idClinic: String = "",
    @ColumnInfo("image1") var image1: String = "",
    @ColumnInfo("image2") var image2: String = "",
    @ColumnInfo("weight") var weight: Double = 0.0,
    @ColumnInfo("age") val age: Int = 0,
)
