package com.rklaumbach.workoutlog.Controller

import android.os.Bundle
import android.util.Log
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.rklaumbach.workoutlog.Adapters.WorkoutRecycleAdapter
import com.rklaumbach.workoutlog.Model.LogEntry
import com.rklaumbach.workoutlog.R
import com.rklaumbach.workoutlog.RoomDatabase.AppDatabase
import com.rklaumbach.workoutlog.Utilities.EXTRA_LOG_ID

import kotlinx.android.synthetic.main.activity_workout.*
import kotlinx.android.synthetic.main.content_workout.*
import kotlinx.android.synthetic.main.content_main.*

class WorkoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_workout)
        setSupportActionBar(toolbar)

        val builder = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "log"
        ).allowMainThreadQueries()
        val db = builder.build()

        val logId: Int = intent.getIntExtra(EXTRA_LOG_ID,-1)
        val workouts = db.workoutDao().loadAllByIds(logId)
        Log.d("logid: ",logId.toString())
        workoutDate.text = db.logDao().loadAllByIds(logId)[0].date

        val adapter = WorkoutRecycleAdapter(this, workouts)
        workoutRecyclerView.adapter = adapter

        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        workoutRecyclerView.layoutManager = layoutManager
        workoutRecyclerView.setHasFixedSize(true)

    }

}


