package com.def.roomsampleapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.def.roomsampleapp.Constants
import com.def.roomsampleapp.model.Student

@Dao
interface StudentDao {

    @Query(Constants.getStudentQuery)
    fun getStudents(): LiveData<List<Student>>

    // Conflict Strategies
    // .IGNORE
    // .ABORT
    // .NONE
    // .REPLACE
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertStudent(student:Student)

    @Query(Constants.deleteStudentsQuery)
    fun deleteStudents()

    @Query(Constants.deleteByName)
    fun deleteByName(name: String)

    @Delete
    fun deleteStudent(student: Student)

    @Update
    fun update(student: Student)

    @Query(Constants.studentByNameQuery)
    fun getStudentByName(name: String): List<Student>

    @Query(Constants.studentBySurnames)
    fun loadAllBySurnames(surname: String): List<Student>

}