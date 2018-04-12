package com.shinayser.essentials.util

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
fun JSONObject.map(vararg pairs: Pair<String, Any?>) {
	pairs.forEach {
		put(it)
	}
}

fun JSONObject.put(pair: Pair<String, Any?>) {
	this.put(pair.first, pair.second)
}

fun jsonOf(vararg pairs: Pair<String, Any>) = JSONObject().apply { map(*pairs) }

fun jsonArrayOf(vararg itens: Any) = JSONArray().apply {
	itens.forEach {
		try {
			put(it)
		} catch (e: Exception) {
		}
	}
}


fun JSONObject.getJsonArrayOrNull(name: String): JSONArray? = this.optJSONArray(name)
fun JSONObject.getJsonObjectOrNull(name: String): JSONObject? = this.optJSONObject(name)
fun JSONObject.getStringOrNull(name: String) = try {
	this.getString(name)
} catch (e: JSONException) {
	null
}

fun JSONObject.getIntOrNull(name: String) = try {
	this.getInt(name)
} catch (e: JSONException) {
	null
}

fun JSONObject.getDoubleOrNull(name: String) = try {
	this.getDouble(name)
} catch (e: JSONException) {
	null
}

fun JSONObject.getLongOrNull(name: String) = try {
	this.getLong(name)
} catch (e: JSONException) {
	null
}

fun JSONObject.getBooleanOrNull(name: String) = try {
	this.getBoolean(name)
} catch (e: JSONException) {
	null
}


//JsonArray
fun JSONArray.getJsonArrayOrNull(index: Int): JSONArray? = this.optJSONArray(index)

fun JSONArray.getJsonObjectOrNull(index: Int): JSONObject? = this.optJSONObject(index)
fun JSONArray.getStringOrNull(index: Int) = try {
	this.getString(index)
} catch (e: JSONException) {
	null
}

fun JSONArray.getIntOrNull(index: Int) = try {
	this.getInt(index)
} catch (e: JSONException) {
	null
}

fun JSONArray.getDoubleOrNull(index: Int) = try {
	this.getDouble(index)
} catch (e: JSONException) {
	null
}

fun JSONArray.getLongOrNull(index: Int) = try {
	this.getLong(index)
} catch (e: JSONException) {
	null
}

fun JSONArray.getBooleanOrNull(index: Int) = try {
	this.getBoolean(index)
} catch (e: JSONException) {
	null
}

fun JSONArray.iterate() = (0 until this.length())


class JSONObjectBuilder {

	private var jsonObject = JSONObject()

	infix fun String.oto(value: Any) = this@JSONObjectBuilder.apply {
		jsonObject.put(this@oto, value)
	}

	infix fun String.otopt(value: Any?) = this@JSONObjectBuilder.apply {

		value?.let {
			jsonObject.put(this@otopt, it)
		}

	}

	fun build() = jsonObject

}


fun jsonOf(block: JSONObjectBuilder.() -> Unit): JSONObject = JSONObjectBuilder().let {
	it.block()
	it.build()
}