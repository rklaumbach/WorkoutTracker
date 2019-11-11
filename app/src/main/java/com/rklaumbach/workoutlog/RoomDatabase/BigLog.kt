package com.rklaumbach.workoutlog.RoomDatabase

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rklaumbach.workoutlog.Model.LogEntry

@Entity
data class BigLog(@PrimaryKey val logId:Int,
                  @ColumnInfo(name = "date") val date :String,
                  @ColumnInfo(name = "num_workouts") val num:Int
               )