package com.shinayser.essentials.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shinayser.essentials.util.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        textView.text = jsonOf(
                randomName() to jsonArrayOf(randomInt(10), randomInt(10)),
                randomName() to randomLong(),
                randomName() to randomCalendar(),
                randomName() to randomFrom("First", "Second", "Third"),
                randomName() to Calendar.getInstance().apply {
                    year = 1999
                    hour = 10
                    minute = 10
                    second = 10
                }
        ).toString()

    }
}
