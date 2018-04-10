package com.shinayser.essentials.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import androidx.core.text.bold
import androidx.core.text.buildSpannedString
import androidx.core.text.scale
import com.shinayser.essentials.recyclerview.DefaultGrid
import com.shinayser.essentials.recyclerview.init
import com.shinayser.essentials.util.boldScale
import com.shinayser.essentials.util.listOfRandoms
import com.shinayser.essentials.util.optionalSerializable
import com.shinayser.essentials.util.randomName
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


//            onBindViewHolder<People, ItemViewBinding>(R.layout.item_view, listOfPeople) { item, holder ->
//                holder.itemView.textView.text = "${item.name} ${item.surname}"
//
//                holder.itemView.textView.setBackgroundColor(
//                        randomFrom(Color.RED,
//                                Color.GREEN,
//                                Color.GRAY,
//                                Color.MAGENTA,
//                                Color.YELLOW,
//                                Color.CYAN))
//            }

		}


//        supportLoaderManager.initLoader(0, null, createLoader<Cursor> {
//
//            loaderCreation { id, args -> CursorLoader(this@MainActivity) }
//
//            loadFinished { loader, data ->
//
//
//
//            }
//
//
//        })


	}
}

//	bold {
//		scale(1.1f){
//			append("Texto")
//		}
//	}
//
//}

data class People(val name: String, val surname: String) : Serializable
