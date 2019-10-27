package com.rklaumbach.workoutlog.Adapters

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.rklaumbach.workoutlog.Model.LogEntry
import com.rklaumbach.workoutlog.R
import kotlinx.android.synthetic.main.log_list_item.view.*

class LogRecycleAdapter(val context: Context, val entries :List<LogEntry>, val itemClick: (LogEntry) -> Unit) : RecyclerView.Adapter<LogRecycleAdapter.Holder>(){
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


    inner class Holder(itemView: View, val itemClick: (LogEntry) -> Unit) : RecyclerView.ViewHolder(itemView) {
        val logDate = itemView?.findViewById<TextView> (R.id.logDate)
        val numWorkouts = itemView?.findViewById<TextView>(R.id.logNumWorkouts)

        @SuppressLint("SetTextI18n")
        fun bindLog (logEntry: LogEntry, context: Context){
            logDate.text = logEntry.date
            numWorkouts.text = logEntry.workouts.size.toString() + " workouts"
            itemView.setOnClickListener{itemClick(logEntry)}
        }





    }

}