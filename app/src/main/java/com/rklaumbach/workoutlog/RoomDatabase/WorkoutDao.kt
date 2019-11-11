package com.rklaumbach.workoutlog.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface WorkoutDao {
    @Query("SELECT * FROM workout")
    fun getAll(): List<Workout>

    @Query("SELECT * FROM workout WHERE from_log = :logId ")
    fun loadAllByIds(logId: Int): List<Workout>

    @Insert
    fun insertAll(vararg entries: BigLog)

    @Delete
    fun delete(user: BigLog)
}