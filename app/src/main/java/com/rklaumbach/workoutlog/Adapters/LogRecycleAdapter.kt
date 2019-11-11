package com.rklaumbach.workoutlog.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rklaumbach.workoutlog.R


class LogRecycleAdapter(val context: Context, val entries: List<com.rklaumbach.workoutlog.RoomDatabase.BigLog>, val itemClick: (com.rklaumbach.workoutlog.RoomDatabase.BigLog) -> Unit) : androidx.recyclerview.widget.RecyclerView.Adapter<LogRecycleAdapter.Holder>(){

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): Holder {
        val view = LayoutInflater.from(context)
            .inflate(R.layout.log_list_item, p0, false)
        return Holder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return entries.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder?.bindLog(entries[position], context)

    }


    inner class Holder(itemView: View, val itemClick: (com.rklaumbach.workoutlog.RoomDatabase.BigLog) -> Unit) : androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView) {
        val logDate = itemView?.findViewById<TextView> (R.id.logDate)
        val numWorkouts = itemView?.findViewById<TextView>(R.id.logNumWorkouts)

        @SuppressLint("SetTextI18n")
        fun bindLog (logEntry: com.rklaumbach.workoutlog.RoomDatabase.BigLog, context: Context){
            logDate.text = logEntry.date
            numWorkouts.text = logEntry.num.toString() + " workouts"
            itemView.setOnClickListener{itemClick(logEntry)}
        }





    }

}