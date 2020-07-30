package ru.itmo.hometask3forchapter5

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.NumberFormatException
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    lateinit var buttonForSum: Button
    lateinit var etNumberOne: EditText
    lateinit var etNumberTwo: EditText
    lateinit var buttonForMultiply: Button
    lateinit var buttonForAbsDif: Button

    lateinit var stNumOne: String
    lateinit var stNumTwo: String
//    var numOne: Int = Integer.parseInt(stNumOne)
//    var numTwo: Int = Integer.parseInt(stNumTwo)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonForMultiply = findViewById(R.id.buttonForMultiply)
        buttonForAbsDif = findViewById(R.id.buttonForAbsDif)
        buttonForSum = findViewById(R.id.buttonForSum)
        etNumberOne = findViewById(R.id.etNumberOne)
        etNumberTwo = findViewById(R.id.etNumberTwo)

    }

    fun onClickSum(view: View) {
        stNumOne = etNumberOne.text.toString()
        stNumTwo = etNumberTwo.text.toString()

        var numOne: Int = 0
        var numTwo: Int = 0

        try {
            numOne = Integer.parseInt(stNumOne)
            numTwo = Integer.parseInt(stNumTwo)
        } catch (e: NumberFormatException) {}

        Toast.makeText(this, "the sum of 2 numbers = ${numOne + numTwo}", Toast.LENGTH_LONG).show()
    }

    fun onClickMult(view: View) {
        stNumOne = etNumberOne.text.toString()
        stNumTwo = etNumberTwo.text.toString()

        var numOne: Int = 0
        var numTwo: Int = 0

        try {
            numOne = Integer.parseInt(stNumOne)
            numTwo = Integer.parseInt(stNumTwo)
        } catch (e: NumberFormatException) {}

        Toast.makeText(this, "the product of 2 numbers = ${numOne * numTwo}", Toast.LENGTH_LONG).show()
    }

    fun onClickAbsDif(view: View) {
        stNumOne = etNumberOne.text.toString()
        stNumTwo = etNumberTwo.text.toString()

        var numOne: Int = 0
        var numTwo: Int = 0

        try {
            numOne = Integer.parseInt(stNumOne)
            numTwo = Integer.parseInt(stNumTwo)
        } catch (e: NumberFormatException) {}

        Toast.makeText(this, "the absolute difference between 2 numbers = ${abs(numOne -numTwo)}", Toast.LENGTH_LONG).show()
    }
}