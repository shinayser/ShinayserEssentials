package com.shinayser.essentials.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.shinayser.essentials.jsonserializer.SimpleJSONSerializable
import com.shinayser.essentials.recyclerview.CustomSpanGrid
import com.shinayser.essentials.recyclerview.init
import com.shinayser.essentials.sample.databinding.ItemViewBinding
import com.shinayser.essentials.util.*

class MainActivity : AppCompatActivity(), ResTrait {

	private val extraString by optionalSerializable<People>("extraPeople")

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContentView(R.layout.activity_main)

		val recyler = findViewById<RecyclerView>(R.id.recycler)

		val listOfPeople = listOfRandoms(50) {
			People(666, true, 'B', randomName(), randomName())
		}


		R.string.app_name.stringRes()

		recyler.init {
			spacing = 0
			layoutType = CustomSpanGrid(1)
			colorDivider(Color.RED)


			onBindViewHolder<People, ItemViewBinding>(R.layout.item_view, listOfPeople) { item, holder ->
//				holder.binding.textView.text = People(-1, false, 'a', "", "").apply { deserialize(item.serialize()) }.serialize().toString(2)
				holder.binding.textView.text = R.string.app_name.stringRes()
			}

		}


	}
}

data class People(var id: Long, var aBoolean: Boolean, var aChar: Char = 'C', val name: String, val surname: String) : SimpleJSONSerializable
