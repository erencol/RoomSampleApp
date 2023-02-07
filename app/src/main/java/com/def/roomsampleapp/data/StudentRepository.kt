package com.def.roomsampleapp.data

import android.app.Application
import androidx.lifecycle.LiveData
import com.def.roomsampleapp.model.Student

class StudentRepository {

    private var studentDao: StudentDao
    private var allStudents: LiveData<List<Student>>

    constructor (application: Application) {
        val studentDatabase = StudentDatabase.getInstance(application)
        studentDao = studentDatabase.studentDao()
        allStudents = studentDao.getStudents()
    }

    fun getAllStudents(): LiveData<List<Student>> {
        return allStudents
    }

    fun insert(student: Student) {
        StudentDatabase.databaseWriteExecutor?.execute {
            studentDao.insertStudent(student)
        }
    }

    fun deleteAll(){
        studentDao.deleteStudents()
    }

    fun deleteByName(name: String){

    }

}