package ru.itmo.hometask7forchapter5

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.lang.NumberFormatException


class MainActivity : AppCompatActivity() {

    lateinit var button: Button
    lateinit var tvRandNumber: TextView
    lateinit var etMyNumber: EditText
    lateinit var tvResult: TextView

    var random = 0
    var gameFinished: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        tvRandNumber = findViewById(R.id.tvRandNumber)
        etMyNumber = findViewById(R.id.etMyNumber)
        tvResult = findViewById(R.id.tvResult)

        gameFinished = false
        random = (1..9).random()

        etMyNumber.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
                // действия, когда вводится какой то текст
                // s - то, что вводится, для преобразования в строку - s.toString()
            }

            override fun afterTextChanged(editable: Editable) {
                if (editable.isEmpty()) etMyNumber.error = "This field cannot be empty"
                else etMyNumber.error = null

                if (editable.length > 1) {
                    etMyNumber.error = "You should enter the number between 1 and 9"
                }
                // действия после того, как что то введено
                // editable - то, что введено. В строку - editable.toString()
            }

            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {

                // действия перед тем, как что то введено
            }
        })

    }

    var counter = 1

    fun clickButton(view: View) {
        if (!gameFinished) {
            val myNumber = etMyNumber.text.toString().toInt()

            if (counter != 5) {
                when {
                    myNumber > random -> {
                        tvResult.text =
                            "Your number is greater. \n Attempts left: ${6-counter}"
                        gameFinished = false
                    }
                    myNumber < random -> {
                        tvResult.text =
                            "Your number is less. \n Attempts left:  ${6-counter}"
                        gameFinished = false
                    }
                    myNumber == random -> {
                        tvResult.text = "Win!"
                        button.text = "Play again!"
                        gameFinished = true
                    }

                }

                counter++
            } else if (counter == 5) {
                tvResult.text = "Game over!"
                tvRandNumber.text = "Random number = $random"
                button.text = "Play again!"
                gameFinished = true
            }

        } else {
            random = (1..9).random()
            tvResult.text = "Try to guess again!"
            tvRandNumber.text = "Random number between 1 and 9"
            button.text = "Click me!"
            counter = 1
            gameFinished = false
        }

        etMyNumber.setText("")
    }
}




















