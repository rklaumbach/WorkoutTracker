package com.rklaumbach.workoutlog.RoomDatabase

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface LogDao {
    @Query("SELECT * FROM bigLog")
    fun getAll(): List<BigLog>

    @Query("SELECT * FROM bigLog WHERE logId = (:id)")
    fun loadAllByIds(id:Int): List<BigLog>

    @Insert
    fun insertAll(vararg entries: BigLog)

    @Delete
    fun delete(user: BigLog)
}

