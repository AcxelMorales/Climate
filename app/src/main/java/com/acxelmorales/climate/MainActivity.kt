package com.acxelmorales.climate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.TextView

import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var tvCity: TextView? = null
    var tvDegrees: TextView? = null
    var tvState: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.tvCity = findViewById(R.id.tvCity)
        this.tvDegrees = findViewById(R.id.tvDegrees)
        this.tvState = findViewById(R.id.tvState)

        val city = intent.getStringExtra("com.acxelmorales.climate.cities.CITY")

        val cityMX = City("Ciudad de México", 20, "Nublado")
        val cityPR = City("Paris", 25, "Soleado")

        if (city == "ciudad-mexico") {
            tvCity?.text = cityMX.name
            tvDegrees?.text = cityMX.degrees.toString() + "º"
            tvState?.text = cityMX.state
        } else if (city == "ciudad-paris") {
            tvCity?.text = cityPR.name
            tvDegrees?.text = cityPR.degrees.toString() + "º"
            tvState?.text = cityPR.state
        } else {
            Toast.makeText(this, "No se encuntra info", Toast.LENGTH_SHORT).show()
        }
    }

}
