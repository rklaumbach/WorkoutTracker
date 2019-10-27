package com.rklaumbach.workoutlog.Controller

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager
import com.rklaumbach.workoutlog.Adapters.WorkoutRecycleAdapter
import com.rklaumbach.workoutlog.Model.LogEntry
import com.rklaumbach.workoutlog.R
import com.rklaumbach.workoutlog.Utilities.EXTRA_LOG_ENTRY

import kotlinx.android.synthetic.main.activity_workout.*
import kotlinx.android.synthetic.main.content_workout.*
import kotlinx.android.synthetic.main.content_main.*

class WorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
        setSupportActionBar(toolbar)

        val logEntry : LogEntry = intent.getParcelableExtra(EXTRA_LOG_ENTRY)
        val workouts = logEntry.workouts
        workoutDate.text = logEntry.date

        val adapter = WorkoutRecycleAdapter(this, workouts)
        workoutRecyclerView.adapter = adapter

        val layoutManager = LinearLayoutManager(this)
        workoutRecyclerView.layoutManager = layoutManager
        workoutRecyclerView.setHasFixedSize(true)

    }

}


