package com.example.project_hostel

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.CalendarView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_hostel.databinding.ActivityMainBinding
import java.util.Calendar
import java.util.logging.Handler

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private lateinit var calendarView: CalendarView
    private val handler = android.os.Handler()
    private val runnable = object : Runnable {
        override fun run() {
            if(::calendarView.isInitialized) {
                // Get the current date from the CalendarView
                val currentTimeInMillis = calendarView.date

                // Increment the date by one day
                val nextDayInMillis =
                    currentTimeInMillis + (24 * 60 * 60 * 1000) // One day in milliseconds

                // Set the next day's date to the CalendarView
                calendarView.setDate(nextDayInMillis, true, true)
            }
            // Schedule the next update in 24 hours
            handler.postDelayed(this, 24 * 60 * 60 * 1000) // 24 hours in milliseconds
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        // calender start
        // Set the CalendarView to today's date
        val calendar = Calendar.getInstance()
        binding.calendarView.setDate(calendar.timeInMillis, true, true)

        // Start the automatic date update
        handler.post(runnable)
        // calender end

        // menu start
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "Mess Time Table"
        // menu end

        //fragment start
        // Check if the savedInstanceState is null (i.e., the first time the activity is created)
        if (savedInstanceState == null) {
            // Add the RoutineFragment to the container
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment, RoutineFragment())
                .commit()
        }
        //fragment end
    }
    // menu start
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_toolbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_search -> {
                // Handle the search action
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
    //menu end
}