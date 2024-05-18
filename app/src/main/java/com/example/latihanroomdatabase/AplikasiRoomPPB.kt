package com.example.latihanroomdatabase

import android.app.Application
import com.example.latihanroomdatabase.db.AppDatabase
import com.example.latihanroomdatabase.db.LocalStudentRepository

class AplikasiRoomPPB : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { LocalStudentRepository(database.studentDAO()) }
}