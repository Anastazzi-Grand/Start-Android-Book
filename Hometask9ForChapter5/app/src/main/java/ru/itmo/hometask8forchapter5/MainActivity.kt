package ru.itmo.hometask8forchapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    lateinit var etCount: EditText
    lateinit var etGrades: EditText
    lateinit var tvArithmeticMean: TextView
    lateinit var tvWarning: TextView
    lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCount = findViewById(R.id.etCount)
        etGrades = findViewById(R.id.etGrades)
        tvArithmeticMean = findViewById(R.id.tvArithmeticMean)
        tvWarning = findViewById(R.id.tvWarning)
        button = findViewById(R.id.button)

        etGrades.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun afterTextChanged(editable: Editable) {
                val regex = Regex("""^(?:[1-5]\,)+[1-5]?${'$'}""")
                val matched = regex.containsMatchIn(editable.toString())

                if (!matched) tvWarning.text = "Please, enter grades from 1 to 5 separated by commas!"
                else tvWarning.text = ""

                if (editable.length != etCount.text.toString().toInt() * 2 - 1) etGrades.error = "The number of grades should be = number of ratings"
                else etGrades.error = null
            }

            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }
        })
    }

    fun clickButton(view: View) {
        var stGrades = etGrades.text.toString()

        val grades = stGrades.split(",").map { it.toInt() }.average()

        tvArithmeticMean.text = "Average of grades = ${(grades*100).roundToInt() / 100.0}"

    }
}