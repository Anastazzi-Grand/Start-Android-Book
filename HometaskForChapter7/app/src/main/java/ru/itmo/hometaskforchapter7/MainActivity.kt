package ru.itmo.hometaskforchapter7

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

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
    var nums = IntArray(9)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (i in tv.indices) tvs[i] = findViewById(tv[i])

    }

    fun fillArray(view: View) {
        for (i in nums.indices) nums[i] = (10..99).random()
        for (i in nums.indices) tvs[i]!!.text = "" + nums[i]
        for (i in nums.indices) {
            tvs[i]!!.setTextColor(Color.BLACK)
            tvs[i]!!.setBackgroundColor(Color.WHITE)
        }
    }

    fun sortAscending(view: View) {
        if (checkArray(nums)) {
            nums.sort()

            for (i in nums.indices) {
                tvs[i]!!.text = "" + nums[i]
                tvs[i]!!.setTextColor(Color.GREEN)
                tvs[i]!!.setBackgroundColor(Color.BLACK)
            }
        } else Toast.makeText(this, "Array is empty", Toast.LENGTH_LONG).show()
    }

    fun sortDescending(view: View) {
        if (checkArray(nums)) {
            nums.sortDescending()

            for (i in nums.indices) {
                tvs[i]!!.text = "" + nums[i]
                tvs[i]!!.setTextColor(Color.RED)
                tvs[i]!!.setBackgroundColor(Color.BLACK)
            }
        } else Toast.makeText(this, "Array is empty", Toast.LENGTH_LONG).show()
    }

    fun nudgeRight(view: View) {
        if (checkArray(nums)) {
            var currentIndex: Int
            var movedIndex: Int
            var buffer: Int
            for (i in 0 until greatestCommonDivisor(1, nums.size)) {
                buffer = nums[i]
                currentIndex = i
                while (true) {
                    movedIndex = currentIndex - 1
                    if (movedIndex < 0) movedIndex += nums.size
                    if (movedIndex == i) break
                    nums[currentIndex] = nums[movedIndex]
                    currentIndex = movedIndex
                }
                nums[currentIndex] = buffer
            }

            for (i in nums.indices) {
                tvs[i]!!.text = "" + nums[i]
                tvs[i]!!.setTextColor(Color.YELLOW)
                tvs[i]!!.setBackgroundColor(Color.BLACK)
            }
        } else Toast.makeText(this, "Array is empty", Toast.LENGTH_LONG).show()
    }

    fun nudgeLeft(view: View) {
        if (checkArray(nums)) {
            var currentIndex: Int
            var movedIndex: Int
            var buffer: Int
            for (i in 0 until greatestCommonDivisor(1, nums.size)) {
                buffer = nums[i]
                currentIndex = i
                while (true) {
                    movedIndex = currentIndex + 1
                    if (movedIndex >= nums.size) movedIndex -= nums.size
                    if (movedIndex == i) break
                    nums[currentIndex] = nums[movedIndex]
                    currentIndex = movedIndex
                }
                nums[currentIndex] = buffer
            }

            for (i in nums.indices) {
                tvs[i]!!.text = "" + nums[i]
                tvs[i]!!.setTextColor(Color.YELLOW)
                tvs[i]!!.setBackgroundColor(Color.BLACK)
            }
        } else Toast.makeText(this, "Array is empty", Toast.LENGTH_LONG).show()
    }

    private fun greatestCommonDivisor(a: Int, b: Int): Int {
        return if (b == 0) a else greatestCommonDivisor(b, a % b)
    }

    private fun checkArray(array: IntArray): Boolean {
        var check = true
        for (i in array.indices) if (array[i] == 0) check = false
        return check
    }
}