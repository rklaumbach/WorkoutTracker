package com.rklaumbach.workoutlog.RoomDatabase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(BigLog::class,Workout::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun logDao(): LogDao
    abstract fun workoutDao(): WorkoutDao
}