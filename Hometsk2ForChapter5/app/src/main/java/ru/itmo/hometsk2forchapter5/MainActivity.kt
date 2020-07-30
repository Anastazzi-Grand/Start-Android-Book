package ru.itmo.hometsk2forchapter5

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var etForNum: EditText
    lateinit var tvRandNum: TextView
    lateinit var greatestNum: TextView
    lateinit var button: Button
    lateinit var stRandNum: String
    lateinit var stNum: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etForNum = findViewById(R.id.etForNum)
        if (etForNum.text.isEmpty()) etForNum.error = "Please, enter a number between 100 and 999"
        tvRandNum = findViewById(R.id.tvRandNum)
        greatestNum = findViewById(R.id.greatestNum)
        button = findViewById(R.id.button)

    }

    fun onClick(view: View) {
        stNum = etForNum.text.toString()
        var myNum: Int = Integer.parseInt(stNum)

        tvRandNum.text = "${(100..999).random()}"
        var myRandNum: Int = Integer.parseInt(stRandNum)
        stRandNum = tvRandNum.text.toString()

        when {
            myNum in 100..999 -> {

                when {
                    myNum > myRandNum -> greatestNum.text = "Your number > Random number"
                    myNum < myRandNum -> greatestNum.text = "Random number > Your number"
                    else -> greatestNum.text = "Your number = Random number"
                }

            }
            myNum < 100 -> {
                etForNum.error =
                    "Your number is less than 100. Please, enter a number between 100 and 999"
            }
            myNum > 999 -> {
                etForNum.error =
                    "Your number is greater than 999. Please, enter a number between 100 and 999"
            }
        }
    }
}