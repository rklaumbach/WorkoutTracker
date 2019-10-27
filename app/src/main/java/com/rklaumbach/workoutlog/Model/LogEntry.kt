package com.rklaumbach.workoutlog.Model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

class LogEntry (val date :String, var workouts :MutableList<WorkoutEntry>) : Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        mutableListOf<WorkoutEntry>().apply {
            parcel.readList(this, WorkoutEntry::class.java.classLoader)
        }
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(date)
        parcel.writeList(workouts)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<LogEntry> {
        override fun createFromParcel(parcel: Parcel): LogEntry {
            return LogEntry(parcel)
        }

        override fun newArray(size: Int): Array<LogEntry?> {
            return arrayOfNulls(size)
        }
    }


};