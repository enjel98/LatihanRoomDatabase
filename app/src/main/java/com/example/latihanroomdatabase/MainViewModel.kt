package com.example.latihanroomdatabase

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.latihanroomdatabase.db.LocalStudentRepository
import com.example.latihanroomdatabase.db.Student
import kotlinx.coroutines.launch

class MainViewModel(private val repository: LocalStudentRepository) : ViewModel() {
    val students: LiveData<List<Student>> = repository.students.asLiveData()
    val isLoading = MutableLiveData<Boolean>()

    fun insert(student: Student) = viewModelScope.launch {
        isLoading.postValue(true)
        repository.insert(student)
        isLoading.postValue(false)

    }

    fun delete(student: Student) = viewModelScope.launch {
        isLoading.postValue(true)
        repository.delete(student)
        isLoading.postValue(false)

    }
}

class MainViewModelFactory(private val repository: LocalStudentRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECK_CAST")
            return MainViewModel(repository) as T

        }
        throw IllegalArgumentException("Unknows ViewModel Class")
    }
}