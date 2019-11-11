package com.rklaumbach.workoutlog.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Workout(@PrimaryKey val workoutId:Int,
               @ColumnInfo(name = "workout_name") val name :String,
               @ColumnInfo(name = "reps") val reps:Int,
               @ColumnInfo(name = "sets") val sets:Int,
               @ColumnInfo(name = "weight") val weight:Float,
               @ColumnInfo(name = "from_log") val fromLog :Int)
