package ru.itmo.hometask3forchapter2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var tvRandomNumber: TextView
    lateinit var tvEvenOrOdd: TextView
    lateinit var positiveOrNegative: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tvRandomNumber = findViewById(R.id.tvRandomNumber)
        tvEvenOrOdd = findViewById(R.id.tvEvenOrOdd)
        positiveOrNegative = findViewById(R.id.positiveOrNegative)
        button = findViewById(R.id.button)
    }

    fun clickMe(view: View) {
        var random = (-100..100).random()
        tvRandomNumber.text = "Random number = $random"

        if (random % 2 == 0) {
            tvEvenOrOdd.text = "Number is even"
            Toast.makeText(this, "Created an EVEN number", Toast.LENGTH_SHORT).show()
        }
        else {
            tvEvenOrOdd.text = "Number is odd"
            Toast.makeText(this, "Created an ODD number", Toast.LENGTH_SHORT).show()
        }

        when {
            random > 0 -> positiveOrNegative.text = "Number is positive"
            random < 0 -> positiveOrNegative.text = "Number is negative"
            else -> positiveOrNegative.text = "Number is equal 0"
        }
    }
}