package com.def.roomsampleapp.data

import android.content.Context
import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.def.roomsampleapp.Constants
import com.def.roomsampleapp.model.Student
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

@Database(
    entities = [Student::class],
    version = Constants.studentDbVersion,
    exportSchema = false,
    autoMigrations = [
        AutoMigration (from = 1, to = 2)
    ])
abstract class StudentDatabase: RoomDatabase() {

    abstract fun studentDao(): StudentDao

    companion object {
        private var INSTANCE: StudentDatabase? = null
        val databaseWriteExecutor: ExecutorService? = Executors.newFixedThreadPool(Constants.NUMBER_OF_THREADS)

        @Synchronized
        fun getInstance(context: Context): StudentDatabase {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.applicationContext, StudentDatabase::class.java, Constants.dbName)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .addMigrations(MIGRATION_1_2, MIGRATION_2_3).
                    build()
            }
            return INSTANCE!!
        }

        private val roomCallback = object: Callback(){
            override fun onCreate(db: SupportSQLiteDatabase) {
                super.onCreate(db)
            }
        }

        private val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("CREATE TABLE `Fruit` (`id` INTEGER, `name` TEXT, " +
                        "PRIMARY KEY(`id`))")
            }
        }

        private val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(database: SupportSQLiteDatabase) {
                database.execSQL("ALTER TABLE Book ADD COLUMN pub_year INTEGER")
            }
        }
    }
}