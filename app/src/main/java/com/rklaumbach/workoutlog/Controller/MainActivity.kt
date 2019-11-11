package com.rklaumbach.workoutlog.Controller

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.core.view.GravityCompat
import androidx.appcompat.app.ActionBarDrawerToggle
import android.view.MenuItem
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.Menu
import androidx.room.Room
import com.rklaumbach.workoutlog.Adapters.LogRecycleAdapter
import com.rklaumbach.workoutlog.Model.WorkoutEntry
import com.rklaumbach.workoutlog.R
import com.rklaumbach.workoutlog.RoomDatabase.AppDatabase
import com.rklaumbach.workoutlog.RoomDatabase.BigLog
import com.rklaumbach.workoutlog.Utilities.EXTRA_LOG_ID
import kotlinx.android.synthetic.main.content_main.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        val boogieWoogie = WorkoutEntry("boogie",1,1,"1.0".toFloat())
        val testWorkouts = mutableListOf(boogieWoogie, boogieWoogie)
        //val log = mutableListOf(LogEntry("today",testWorkouts), LogEntry("today",testWorkouts))

        val builder = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "log"
        ).allowMainThreadQueries()
        val db = builder.build()

        var roomLog = db.logDao().getAll()
        var numLogEntries = roomLog.size

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val adapter = LogRecycleAdapter(this,roomLog) {logEntry ->
            switchToWorkoutActivity(logEntry.logId)
        }
        recyclerView.adapter = adapter

        val layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)

        navView.setNavigationItemSelectedListener(this)

        addNewLogEntry.setOnClickListener {
            val workouts = mutableListOf<WorkoutEntry>()
            val date :String = LocalDate.now().format(DateTimeFormatter.ofPattern("MM/dd/yy"))
            val roomLogEntry = BigLog(numLogEntries+1, date, workouts.size)
            numLogEntries++
            db.logDao().insertAll(roomLogEntry)
            roomLog = db.logDao().getAll()
            switchToWorkoutActivity(roomLogEntry.logId)
        }
    }

    fun switchToWorkoutActivity(logId:Int){
        val workoutActivity = Intent(this, WorkoutActivity::class.java)
        workoutActivity.putExtra(EXTRA_LOG_ID,logId)
        startActivity(workoutActivity)
    }


    override fun onBackPressed() {
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_home -> {
                // Handle the camera action
            }
            R.id.nav_gallery -> {

            }
            R.id.nav_slideshow -> {

            }
            R.id.nav_tools -> {

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }
        }
        val drawerLayout: androidx.drawerlayout.widget.DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
