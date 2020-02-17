package com.mobilecomputing.reminder

import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.room.Room

import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab_add.setOnClickListener {
            Toast.makeText(this, "This is main activity", Toast.LENGTH_SHORT).show()
        }

        fab_time.setOnClickListener {
            val fabTimeIntent = Intent (applicationContext, TimeActivity::class.java)
            startActivity(fabTimeIntent)
        }

        fab_map.setOnClickListener {
            val fabMapIntent = Intent (applicationContext, MapActivity::class.java)
            startActivity(fabMapIntent)
        }

/*        val data = arrayOf("Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday")

        val reminderAdapter = ReminderAdapter(applicationContext, data)
        list.adapter = reminderAdapter*/
    }

    override fun onResume() {
        super.onResume()
        refreshList()
    }

    private fun refreshList() {
        doAsync {
            val db = Room.databaseBuilder(applicationContext, AppDatabase::class.java, "reminders").build()
            val reminders = db.reminderDao().getReminders()
            db.close()

            uiThread {
                if (reminders.isNotEmpty()){
                    val adapter = ReminderAdapter(applicationContext, reminders)
                    list.adapter = adapter
                } else {
                    toast("No reminders yet")
                }
            }
        }
    }
    /*
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
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
    } */
}
