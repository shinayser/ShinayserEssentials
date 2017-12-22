package com.shinayser.essentials.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.shinayser.essentials.recyclerview.DefaultGrid
import com.shinayser.essentials.recyclerview.Linear
import com.shinayser.essentials.recyclerview.SimpleRecyclerAdapter
import com.shinayser.essentials.recyclerview.init
import com.shinayser.essentials.sample.databinding.ItemViewBinding
import com.shinayser.essentials.util.*
import kotlinx.android.synthetic.main.item_view.view.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val extraString by optionalSerializable<People>("extraPeople")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyler = findViewById<RecyclerView>(R.id.recycler)



        recyler.init {
            spacing = 0
            layoutType = DefaultGrid(3)
            divider = R.drawable.line_divider_cool_black.fromResDrawable(applicationContext)

            val listOfPeople = listOfRandoms(5000) {
                People(randomName(), randomName())
            }

            onBindViewHolder<People, ItemViewBinding>(R.layout.item_view, listOfPeople) { item, holder ->
                holder.itemView.textView.text = "${item.name} ${item.surname}"
//                holder.itemView.textView.setBackgroundColor(
//                        randomFrom(Color.RED,
//                                Color.GREEN,
//                                Color.GRAY,
//                                Color.MAGENTA,
//                                Color.YELLOW,
//                                Color.CYAN))
            }

        }

    }
}

data class People(val name: String, val surname: String) : Serializable
