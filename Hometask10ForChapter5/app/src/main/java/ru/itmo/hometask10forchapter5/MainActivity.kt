package ru.itmo.hometask10forchapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.abs

class MainActivity : AppCompatActivity() {

    lateinit var etNumerator: EditText
    lateinit var etDenominator: EditText
    lateinit var buttonCorrect: Button
    lateinit var buttonShrinking: Button
    lateinit var buttonPositive: Button
    lateinit var tvCorrectFraction: TextView
    lateinit var tvShrinkingFraction: TextView
    lateinit var tvPositiveFraction: TextView
    lateinit var tvWarning: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumerator = findViewById(R.id.etNumerator)
        etDenominator = findViewById(R.id.etDenominator)
        buttonCorrect = findViewById(R.id.buttonCorrect)
        buttonShrinking = findViewById(R.id.buttonShrinking)
        buttonPositive = findViewById(R.id.buttonPositive)
        tvCorrectFraction = findViewById(R.id.tvCorrectFraction)
        tvShrinkingFraction = findViewById(R.id.tvShrinkingFraction)
        tvPositiveFraction = findViewById(R.id.tvPositiveFraction)
        tvWarning = findViewById(R.id.tvWarning)

    }

    fun isCorrectOrIncorrect(view: View) {
        if (isValid(etDenominator)) {
            var numerator = etNumerator.text.toString().toInt()
            var denomirator = etDenominator.text.toString().toInt()
            tvCorrectFraction.text = "Fraction is ${if (abs(numerator) < abs(denomirator)) "correct" else if (abs(numerator) > abs(denomirator)) "incorrect" else "1"}"
        } else tvWarning.text = "Denominator cannot be equal 0"
    }
    fun isShrinking(view: View) {
        if (isValid(etDenominator)) {
            var numerator = etNumerator.text.toString().toInt()
            var denomirator = etDenominator.text.toString().toInt()
            var fraction = "$numerator/$denomirator"
            var fractionMain = if (numerator < 0 || denomirator < 0) { "-${reduction(abs(numerator), abs(denomirator))}" } else "${reduction(abs(numerator), abs(denomirator))}"

            tvShrinkingFraction.text = "${if (fractionMain != fraction) "Yes, reduced fraction = $fractionMain" else "Fraction doesn't shrink"}"
        } else tvWarning.text = "Denominator cannot be equal 0"
    }
    fun isPositiveOrNegative(view: View) {
        if (isValid(etDenominator)) {
            var numerator = etNumerator.text.toString().toInt()
            var denomirator = etDenominator.text.toString().toInt()
            tvPositiveFraction.text = "Fraction is ${if (numerator == 0) "0" else if (numerator < 0 || denomirator < 0) "negative" else "positive"}"
        } else tvWarning.text = "Denominator cannot be equal 0"
    }


    private fun isValid(denominator: EditText) : Boolean {
        tvWarning.text = ""
        return denominator.text.toString().toInt() != 0
    }

    private fun nod(a: Int, b: Int): Int {
        var a = a
        var b = b
        while (a != b) {
            if (a > b) a -= b else b -= a
        }
        return a
    }

    private fun reduction(n: Int, d: Int) : String {
        var n = n
        var d = d
        var t: Int = nod(n, d)
        n /= t
        d /= t

        return "$n/$d"
    }

}