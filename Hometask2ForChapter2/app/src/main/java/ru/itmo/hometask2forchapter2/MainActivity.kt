package ru.itmo.hometask2forchapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    lateinit var tvRandom10: TextView
    lateinit var tvRandom100: TextView
    lateinit var sumOfNumbers: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRandom10 = findViewById(R.id.tvRandom10)
        tvRandom100 = findViewById(R.id.tvRandom100)
        sumOfNumbers = findViewById(R.id.sumOfNumbers)
        button = findViewById(R.id.button)
    }

    fun onClick(view: View) {

        var random1 = (100..999).random()
        var random2 = (100..999).random()

        tvRandom10.text = "Number №1 = $random1"
        tvRandom100.text = "Number №2 = $random2"

//        if (abs(random1) > abs(random2)) sumOfNumbers.text = "Number №1 > Number №2"
//        else sumOfNumbers.text = "Number №1 < Number №2"

        if (random1 > random2) sumOfNumbers.text = "$random1 > $random2"
        else if (random1 < random2) sumOfNumbers.text = "$random1 < $random2"
        else sumOfNumbers.text = "$random1 = $random2"

//        sumOfNumbers.text = "Sum of 2 numbers = ${random1 + random2}"
    }
}