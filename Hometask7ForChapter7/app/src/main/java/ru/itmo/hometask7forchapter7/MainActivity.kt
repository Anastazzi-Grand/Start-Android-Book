package ru.itmo.hometask7forchapter7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var etWord: EditText
    var tv = intArrayOf(
        R.id.tv0,
        R.id.tv1,
        R.id.tv2,
        R.id.tv3,
        R.id.tv4,
        R.id.tv5,
        R.id.tv6,
        R.id.tv7,
        R.id.tv8
    )
    var tvs = arrayOfNulls<TextView>(9)
    var chars = CharArray(9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etWord = findViewById(R.id.etWord)
        for (i in tv.indices) tvs[i] = findViewById(tv[i])

    }

    fun putString(view: View) {
        if (checkWord(etWord) && checkWordSize(etWord.text.toString())) {
            var stWord = etWord.text.toString()
            if (stWord.length == 9) {
                chars = stWord.toCharArray()
                for (i in chars.indices) {
                    tvs[i]!!.text = "${chars[i]}"
                }
            } else {
                stWord = stWord.substring(0, 8)
                chars = stWord.toCharArray()
                for (i in chars.indices) {
                    tvs[i]!!.text = "${chars[i]}"
                }
                Toast.makeText(this, "The word's length is bigger than 9. The rest of the letters didn't fit to the array!", Toast.LENGTH_LONG).show()
            }

        } else {
            Toast.makeText(this, "Please, check entered word. Remember the word length must be >= 9", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkWord(editText: EditText) : Boolean {
        return editText.text.toString() != ""
    }

    private fun checkWordSize(word: String): Boolean {
        return word.length >= 9
    }
}