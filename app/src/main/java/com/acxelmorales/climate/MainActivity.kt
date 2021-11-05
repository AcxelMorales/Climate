package com.acxelmorales.climate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.TextView
import android.widget.Toast

import com.android.volley.Request
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

import com.google.gson.Gson

import network.Network

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

        if (Network.networkExist(this)) {
            this.getData("https://api.openweathermap.org/data/2.5/weather?id=$city&appid=null&units=metric&lang=es")
        } else {
            Toast.makeText(this, "No tenemos red", Toast.LENGTH_LONG).show()
        }
    }

    private fun getData(url: String) {
        val queue = Volley.newRequestQueue(this)
        val request = StringRequest(Request.Method.GET, url, {
                response ->
            try {
                val gson = Gson()
                val city = gson.fromJson(response, City::class.java)

                tvCity?.text = city.name
                tvDegrees?.text = city.main?.temp.toString() + "º"
                tvState?.text = city.weather?.get(0)?.description
            } catch (e: Exception) {
                Log.e("Error", e.message.toString())
            }
        }, {  })

        queue.add(request)
    }

}
