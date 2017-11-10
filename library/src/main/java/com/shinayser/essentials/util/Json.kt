package com.shinayser.essentials.util

import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

/**
 * Created by denox on 10/11/2017.
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
        } catch (e: Exception) { }
    }
}

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

fun JSONObject.getJsonArrayOrNull(name: String) = try {
    this.getJSONArray(name)
} catch (e: JSONException) {
    null
}

fun JSONObject.getJsonObjectOrNull(name: String) = try {
    this.getJSONObject(name)
} catch (e: JSONException) {
    null
}
