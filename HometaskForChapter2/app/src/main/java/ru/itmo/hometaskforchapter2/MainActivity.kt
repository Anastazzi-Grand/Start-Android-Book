package ru.itmo.hometaskforchapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var tvNumber: TextView
    lateinit var btnRandomNumber: Button
    lateinit var buttonCounter: Button
    lateinit var btnSumOfNumbers: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvNumber = findViewById(R.id.tvNumber)
        btnRandomNumber = findViewById(R.id.btnRandNumber)
        buttonCounter = findViewById(R.id.buttonCounter)
        btnSumOfNumbers = findViewById(R.id.btnSumOfNumbers)

        var count = 1

        btnRandomNumber.setOnClickListener {
            randomNumber(btnRandomNumber)
            buttonCounter.setText("Number of clicks = ${count++}")

        }
    }

    var sum = 0

    fun randomNumber(view: View) {
        var random = (10..99).random()
        sum += random

        tvNumber.text = "Received number = $random"
        btnSumOfNumbers.text = "The sum of numbers = $sum"
    }
}