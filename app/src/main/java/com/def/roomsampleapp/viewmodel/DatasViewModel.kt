package com.def.roomsampleapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.def.roomsampleapp.data.StudentRepository
import com.def.roomsampleapp.model.Student

class DatasViewModel(application: Application) : AndroidViewModel(application) {

    var repository: StudentRepository
    var allStudents: LiveData<List<Student>>

    init {
        repository = StudentRepository(application)
        allStudents = repository.getAllStudents()
    }

    fun insert(student: Student) {
        repository.insert(student)
    }

    fun deleteAll() {
        repository.deleteAll()
    }

    fun deleteByName(name:String){
        repository.deleteByName(name)
    }
}