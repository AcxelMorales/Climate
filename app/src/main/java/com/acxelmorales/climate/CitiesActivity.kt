package com.acxelmorales.climate

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Button

class CitiesActivity : AppCompatActivity() {

    private val TAG = "com.acxelmorales.climate.cities.CITY"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities)

        val btnMexico = findViewById<Button>(R.id.btnMexicoCity)
        val btnParis = findViewById<Button>(R.id.btnParis)

        btnMexico.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(this.TAG, "3527646")
            startActivity(intent)
        }

        btnParis.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra(this.TAG, "2988507")
            startActivity(intent)
        }
    }

}
