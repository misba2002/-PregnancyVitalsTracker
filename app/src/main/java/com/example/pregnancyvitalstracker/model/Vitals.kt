package com.example.pregnancyvitalstracker.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "vitals_table")
data class Vitals(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val heartRate: Int,
    val bpSys: Int,
    val bpDia: Int,
    val weight: Float,
    val kicks: Int,
    val timestamp: Long = System.currentTimeMillis()
)
