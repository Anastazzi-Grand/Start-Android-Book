package ru.itmo.hometask5_6forchapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException

class MainActivity : AppCompatActivity() {

    lateinit var editTextNumber: EditText
    lateinit var tvMinute: TextView
    lateinit var buttonMinute: Button
    lateinit var tvFar: TextView
    lateinit var buttonFar: Button
    lateinit var stNumber: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editTextNumber = findViewById(R.id.editTextNumber)
        tvMinute = findViewById(R.id.tvMinute)
        buttonMinute = findViewById(R.id.buttonMinute)
        tvFar = findViewById(R.id.tvFar)
        buttonFar = findViewById(R.id.buttonFar)
    }

    fun clickMinutes(view: View) {
        stNumber = editTextNumber.text.toString()

        var number: Double

        try {
            number = stNumber.toDouble()
        } catch (e: NumberFormatException) {
            tvMinute.text = "Value is empty"
            return
        }

        tvMinute.text = "$stNumber sec = ${(number % 3600) / 60} minutes"
    }

    fun clickFahrenheit(view: View) {
        stNumber = editTextNumber.text.toString()

        var number: Double

        try {
            number = stNumber.toDouble()
        } catch (e: NumberFormatException) {
            tvMinute.text = "Value is empty"
            return
        }

        tvMinute.text = "$stNumber Celsius = ${(number * 9/5) + 32} Fahrenheit"
    }
}