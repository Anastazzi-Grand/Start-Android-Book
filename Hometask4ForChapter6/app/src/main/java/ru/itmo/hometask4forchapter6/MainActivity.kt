package ru.itmo.hometask4forchapter6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    lateinit var etH0: EditText
    lateinit var etV0: EditText
    lateinit var etT: EditText
    lateinit var button: Button
    lateinit var tvResult: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etH0 = findViewById(R.id.etH0)
        etV0 = findViewById(R.id.etV0)
        etT = findViewById(R.id.etT)
        button = findViewById(R.id.button)
        tvResult = findViewById(R.id.tvResult)

    }

    fun clickButton(view: View) {
        var h0 = etH0.text.toString().toDouble()
        var v0 = etV0.text.toString().toDouble()
        var t = etT.text.toString().toDouble()

        tvResult.text = "${h0 + v0*t + 0.5*9.8*t.pow(2.0)}"
    }
}