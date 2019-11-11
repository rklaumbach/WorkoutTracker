package com.rklaumbach.workoutlog.Adapters

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rklaumbach.workoutlog.Model.WorkoutEntry
import com.rklaumbach.workoutlog.R
import com.rklaumbach.workoutlog.RoomDatabase.Workout

class WorkoutRecycleAdapter(val context : Context, val workouts :List<Workout>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<WorkoutRecycleAdapter.Holder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.workout_list_item, p0, false)
        return Holder(view)

    }

    override fun getItemCount(): Int {
        return workouts.count()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindWorkout(workouts[position],context)
    }


    inner class Holder(itemView: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        var workoutName =itemView?.findViewById<TextView> (R.id.workoutName)
        var reps = itemView?.findViewById<TextView>(R.id.reps)
        var sets = itemView?.findViewById<TextView>(R.id.sets)
        var weight = itemView?.findViewById<TextView>(R.id.weight)

        fun bindWorkout(workout :Workout, context: Context){
            workoutName?.text = workout.name
            reps?.text = workout.reps.toString()
            sets?.text = workout.sets.toString()
            weight?.text = workout.weight.toString()
        }




    }
}