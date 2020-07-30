package ru.itmo.hometask5forchapter6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var etNumbers: EditText
    lateinit var tvAscendingOrder: TextView
    lateinit var tvDescendingOrder: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumbers = findViewById(R.id.etNumbers)
        tvAscendingOrder = findViewById(R.id.tvAscendingOrder)
        tvDescendingOrder = findViewById(R.id.tvDescendingOrder)

    }

    fun ascendingOrder(view: View) {
        var ascendingNumbers = etNumbers.text.toString().split(" ").map { it.toInt() }.sorted()
        tvAscendingOrder.text = ascendingNumbers.toString()
    }
    fun descendingOrder(view: View) {
        var descendingNumbers = etNumbers.text.toString().split(" ").map { it.toInt() }.sortedDescending()
        tvDescendingOrder.text = descendingNumbers.toString()
    }
}