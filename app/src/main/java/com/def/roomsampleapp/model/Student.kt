package com.def.roomsampleapp.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.def.roomsampleapp.Constants

@Entity(tableName = Constants.tableName)
data class Student(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = Constants.studentIdColumn) // Allows define different columnName
    var studentId: Int = 0, // or studentId: Int? = null

    @ColumnInfo(name = Constants.nameColumnName)
    val name: String,

    @ColumnInfo(name = Constants.surnameColumnName)
    val surname: String?,

    @ColumnInfo(name = Constants.ageColumnName)
    val age: String?
)
