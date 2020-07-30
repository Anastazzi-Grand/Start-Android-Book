package ru.itmo.hometask8forchapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var etDepartureTimeHours: EditText
    lateinit var etDepartureTimeMinutes: EditText
    lateinit var etArrivalTimeHours: EditText
    lateinit var etArrivalTimeMinutes: EditText
    lateinit var tvTravelTime: TextView
    lateinit var tvCalcTime: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etDepartureTimeHours = findViewById(R.id.etDepartureTimeHours)
        etDepartureTimeMinutes = findViewById(R.id.etDepartureTimeMinutes)
        etArrivalTimeHours = findViewById(R.id.etArrivalTimeHours)
        etArrivalTimeMinutes = findViewById(R.id.etArrivalTimeMinutes)
        tvTravelTime = findViewById(R.id.tvTravelTime)
        tvCalcTime = findViewById(R.id.tvCalcTime)
        button = findViewById(R.id.button)

    }



    fun clickButton(view: View) {
        var departureHours = etDepartureTimeHours.text.toString().toDouble()
        var departureMinutes = etDepartureTimeMinutes.text.toString().toDouble()
        var arrivalHours = etArrivalTimeHours.text.toString().toDouble()
        var arrivalMinutes = etArrivalTimeMinutes.text.toString().toDouble()

        if (checkHours(departureHours) && checkHours(arrivalHours) && checkMinutes(departureMinutes) && checkMinutes(arrivalMinutes)) {
            tvCalcTime.text = "Let's calculate the travel time!"
            var departureTime = departureHours + minutesToHours(departureMinutes)
            var arrivalTime = arrivalHours + minutesToHours(arrivalMinutes)

            if (checkTravelTime(departureTime, arrivalTime)) {
                tvTravelTime.text =
                    "Travel time = ${((arrivalTime - departureTime) * 100).roundToInt() / 100.0} hours"
            } else {
                tvCalcTime.text = "Departure time should be less than Arrival time!"
                tvTravelTime.text = "????"
            }

        } else {
            tvCalcTime.text =
                "Please, check your entered data!\nRemember that there're 24 hours in a day\nand 60 minutes in 1 hour!"
            tvTravelTime.text = "????" 
        }

    }

    private fun minutesToHours(minutes: Double) : Double {
        return ((minutes / 60) * 100).roundToInt() /100.0
    }

    private fun checkHours(hours: Double) : Boolean {
        return hours in 0.0..23.0
    }

    private fun checkMinutes(minutes: Double) : Boolean {
        return minutes in 0.0..60.0
    }

    private fun checkTravelTime(departureTime: Double, arrivalTime: Double) : Boolean {
        return departureTime < arrivalTime
    }


}