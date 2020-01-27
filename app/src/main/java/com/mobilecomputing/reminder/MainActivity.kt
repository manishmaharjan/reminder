package com.mobilecomputing.reminder

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

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
