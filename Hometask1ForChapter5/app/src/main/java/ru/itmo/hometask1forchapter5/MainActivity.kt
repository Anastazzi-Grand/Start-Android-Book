package ru.itmo.hometask1forchapter5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var etNumOne: EditText
    lateinit var etNumTwo: EditText
    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var stNumOne: String
    lateinit var stNumTwo: String


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNumOne = findViewById(R.id.etNumOne)
        etNumTwo = findViewById(R.id.etNumTwo)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)

    }

    fun ClickButton(view: View) {

        stNumOne = etNumOne.text.toString()
        stNumTwo = etNumTwo.text.toString()

        var myNumOne = Integer.parseInt(stNumOne)
        var myNumTwo = Integer.parseInt(stNumTwo)

        when {
            myNumOne == myNumTwo -> textView.text = "Number1 = Number2"
            myNumOne > myNumTwo -> textView.text = "Number1 > Number2"
            else -> textView.text = "Number2 > Number1"
        }

    }
}