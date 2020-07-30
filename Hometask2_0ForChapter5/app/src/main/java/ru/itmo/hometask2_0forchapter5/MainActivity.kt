package ru.itmo.hometask2_0forchapter5

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

        var randomNum = (100..999).random()

        tvRandNum.text = "$randomNum"

        stNum = etForNum.text.toString()

        var myNumber = Integer.parseInt(stNum)

//        etForNum.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
//
//            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
//
//            override fun afterTextChanged(s: Editable) {
//                myNumber = try {
//                    etForNum.text.toString().toInt()
//
//                } catch (e: NumberFormatException) {
//                    etForNum.setText("200")
//                    greatestNum.text = "Empty String"
//                    return
//                }
//                if (myNumber !in 100..999) {
//                    etForNum.setText("200")
//                    greatestNum.text = "Your number is out of range."
//                    tvRandNum.text = "Stop"
//                }
//            }
//        })

        etForNum.onFocusChangeListener = View.OnFocusChangeListener { v, hasFocus ->
            if (!hasFocus) {
                try {
                    myNumber = Integer.parseInt(stNum)
                } catch (exception: NumberFormatException) {
                    greatestNum.text = "You haven't entered anything."
                    return@OnFocusChangeListener
                }

                if (myNumber < 100 || myNumber > 999) greatestNum.text = "Your number is out of range."
            }
        }

        when {
            myNumber > randomNum -> greatestNum.text = "Your number > Random number"
            myNumber < randomNum -> greatestNum.text = "Random number > Your number"
            myNumber == randomNum -> greatestNum.text = "Your number = Random number"
        }


    }
}