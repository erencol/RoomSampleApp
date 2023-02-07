package com.def.roomsampleapp

class Constants {
    companion object {
        const val dbName = "student_database"
        const val tableName = "students"
        const val studentIdColumn = "studentId"
        const val nameColumnName = "name"
        const val surnameColumnName = "surname"
        const val ageColumnName = "age"
        const val getStudentQuery = "SELECT * FROM $tableName"
        const val deleteStudentsQuery = "DELETE FROM $tableName"
        const val studentByNameQuery = "Select * FROM $tableName where $nameColumnName LIKE :$nameColumnName"
        const val studentBySurnames = "SELECT * FROM $tableName WHERE $surnameColumnName IN (:$surnameColumnName)"
        const val deleteByName = "DELETE FROM $tableName where $nameColumnName = :$nameColumnName"
        const val studentDbVersion = 1
        const val NUMBER_OF_THREADS = 4
    }
}