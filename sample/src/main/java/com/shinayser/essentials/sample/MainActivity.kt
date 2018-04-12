package com.shinayser.essentials.sample

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.RecyclerView
import com.shinayser.essentials.jsonserializer.SimpleJSONSerializable
import com.shinayser.essentials.recyclerview.CustomSpanGrid
import com.shinayser.essentials.recyclerview.init
import com.shinayser.essentials.sample.databinding.ItemViewBinding
import com.shinayser.essentials.util.listOfRandoms
import com.shinayser.essentials.util.optionalSerializable
import com.shinayser.essentials.util.randomName

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
			layoutType = CustomSpanGrid(1)
			colorDivider(Color.RED)


			onBindViewHolder<People, ItemViewBinding>(R.layout.item_view, listOfPeople) { item, holder ->
				holder.binding.textView.text = item.serialize().toString(2)
			}

		}


	}
}

data class People(val name: String, val surname: String) : SimpleJSONSerializable
