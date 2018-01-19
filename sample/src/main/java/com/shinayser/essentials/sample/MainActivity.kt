package com.shinayser.essentials.sample

import android.database.Cursor
import android.graphics.Color
import android.os.Bundle
import android.support.v4.content.CursorLoader
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.shinayser.essentials.loader.createLoader
import com.shinayser.essentials.recyclerview.DefaultGrid
import com.shinayser.essentials.recyclerview.init
import com.shinayser.essentials.sample.databinding.ItemViewBinding
import com.shinayser.essentials.util.listOfRandoms
import com.shinayser.essentials.util.optionalSerializable
import com.shinayser.essentials.util.randomFrom
import com.shinayser.essentials.util.randomName
import kotlinx.android.synthetic.main.item_view.view.*
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    private val extraString by optionalSerializable<People>("extraPeople")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyler = findViewById<RecyclerView>(R.id.recycler)

        val listOfPeople = listOfRandoms(50) {
            People(randomName(), randomName())
        }

        recyler.init {
            spacing = 0
            layoutType = DefaultGrid(2)
            colorDivider(Color.RED)


            onBindViewHolder<People, ItemViewBinding>(R.layout.item_view, listOfPeople) { item, holder ->
                holder.itemView.textView.text = "${item.name} ${item.surname}"

                holder.itemView.textView.setBackgroundColor(
                        randomFrom(Color.RED,
                                Color.GREEN,
                                Color.GRAY,
                                Color.MAGENTA,
                                Color.YELLOW,
                                Color.CYAN))
            }

        }


        supportLoaderManager.initLoader(0, null, createLoader<Cursor> {

            loaderCreation { id, args -> CursorLoader(this@MainActivity) }

            loadFinished { loader, data ->



            }


        })


    }
}

data class People(val name: String, val surname: String) : Serializable
