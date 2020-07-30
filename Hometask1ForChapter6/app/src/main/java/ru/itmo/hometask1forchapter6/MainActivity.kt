package ru.itmo.hometask1forchapter6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {

    lateinit var etA: EditText
    lateinit var etB: EditText
    lateinit var etC: EditText
    lateinit var button: Button
    lateinit var tvRoot1: TextView
    lateinit var tvRoot2: TextView
    lateinit var tvWarning: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etA = findViewById(R.id.etA)
        etB = findViewById(R.id.etB)
        etC = findViewById(R.id.etC)
        button = findViewById(R.id.button)
        tvRoot1 = findViewById(R.id.tvRoot1)
        tvRoot2 = findViewById(R.id.tvRoot2)
        tvWarning = findViewById(R.id.tvRoot2)

    }

    fun clickButton(view: View) {
        var a = etA.text.toString().toDouble()
        var b = etB.text.toString().toDouble()
        var c = etC.text.toString().toDouble()
        var x1: Double
        var x2: Double

        var d = b.pow(2.0) - (4 * a * c)

        if (d > 0) {
            x1 = (-1 * b + sqrt(d)) / 2 * a
            x2 = (-1 * b - sqrt(d)) / 2 * a
            tvRoot1.text = "$x1"
            tvRoot2.text = "$x2"
        } else if (d == 0.0) {
            x1 = -1 * b
            tvRoot1.text = "$x1"
            tvRoot2.text = "$x1"
        } else {
            tvRoot1.text = "Nothing"
            tvRoot2.text = "Nothing"
        }

    }

}