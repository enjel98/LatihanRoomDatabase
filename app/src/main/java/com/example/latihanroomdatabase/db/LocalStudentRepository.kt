package com.example.latihanroomdatabase.db

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class LocalStudentRepository(private val studentDAO: StudentDAO) {
    val students: Flow<List<Student>> = studentDAO.getAll()

    @WorkerThread
    suspend fun insert(student: Student) {
        studentDAO.insert(student)
    }

    @WorkerThread
    suspend fun delete(student: Student) {
        studentDAO.delete(student)
    }
}