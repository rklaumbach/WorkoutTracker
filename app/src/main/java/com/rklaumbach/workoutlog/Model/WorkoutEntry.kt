package com.rklaumbach.workoutlog.Model

import android.os.Parcel
import android.os.Parcelable

class WorkoutEntry (val name :String, var reps :Int, var sets :Int, var weight :Float) :Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readInt(),
        parcel.readInt(),
        parcel.readFloat()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeInt(reps)
        parcel.writeInt(sets)
        parcel.writeFloat(weight)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WorkoutEntry> {
        override fun createFromParcel(parcel: Parcel): WorkoutEntry {
            return WorkoutEntry(parcel)
        }

        override fun newArray(size: Int): Array<WorkoutEntry?> {
            return arrayOfNulls(size)
        }
    }

}