package com.shinayser.essentials.sample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.shinayser.essentials.util.*
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable
import java.util.*

class MainActivity : AppCompatActivity() {

    private val extraString by optionalSerializable<People>("extraPeople")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView.text = jsonOf(
                randomName() to jsonArrayOf(randomInt(10), randomInt(10)),
                randomName() to randomLong(),
                randomName() to randomCalendar().year,
                randomName() to randomFrom("First", "Second", "Third"),
                randomName() to Calendar.getInstance().apply {
                    year = 1999
                    hour = 10
                    minute = 10
                    second = 10
                }.second
        ).toString(5) + "\n\n" + extraString

        if (extraString == null) {
            startActivity(Intent(this, MainActivity::class.java).apply {
                putExtra( "extraPeople", People("Daniel", "Oliveira"))
            })
            finish()
        }

    }
}

data class People(val name: String, val surname: String) : Serializable
