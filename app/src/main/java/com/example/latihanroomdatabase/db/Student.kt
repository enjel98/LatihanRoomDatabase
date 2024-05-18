package com.example.latihanroomdatabase.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "nim") val nim: String,
    @ColumnInfo(name = "nama") val nama: String
)
