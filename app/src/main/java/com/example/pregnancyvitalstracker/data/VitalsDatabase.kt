package com.example.pregnancyvitalstracker.data

import com.example.pregnancyvitalstracker.model.Vitals

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Vitals::class], version = 1, exportSchema = false)
abstract class VitalsDatabase : RoomDatabase() {

    abstract fun vitalsDao(): VitalsDao

    companion object {
        @Volatile
        private var INSTANCE: VitalsDatabase? = null

        fun getDatabase(context: Context): VitalsDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    VitalsDatabase::class.java,
                    "vitals_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
