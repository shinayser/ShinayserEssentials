package com.shinayser.essentials.util

import android.content.Context
import android.graphics.Color
import org.json.JSONObject

/**
 * Created by denox on 10/11/2017.
 */
fun String.toJson(): JSONObject? {

    return try {
        val jsonObject = JSONObject(this)
        jsonObject
    } catch (e: Exception) {
        e.printStackTrace()
        null
    }

}

//Int
fun Int.lessThan(n : Int) = this < n
fun Int.lessOrEqual(n : Int) = this <= n
fun Int.greaterThan(n : Int) = this > n
fun Int.greaterThanOrEqual(n : Int) = this >= n

//Double
fun Double.lessThan(n : Double) = this < n
fun Double.lessThanOrEqual(n : Double) = this <= n
fun Double.greaterThan(n : Double) = this > n
fun Double.greaterThanOrEqual(n : Double) = this >= n

//Long
fun Long.lessThan(n : Long) = this < n
fun Long.lessThanOrEqual(n : Long) = this <= n
fun Long.greaterThan(n : Long) = this > n
fun Long.greaterThanOrEqual(n : Long) = this >= n

//Float
fun Float.lessThan(n : Float) = this < n
fun Float.lessThanOrEqual(n : Float) = this <= n
fun Float.greaterThan(n : Float) = this > n
fun Float.greaterThanOrEqual(n : Float) = this >= n

//Integer resources quick convertion
fun Int.fromResString(context: Context, vararg params: Any) = if (params.isEmpty()) context.getString(this) else context.getString(this, *params)
fun Int.fromResInteger(context: Context) = context.resources.getInteger(this)
fun Int.fromResColor(context: Context) = context.resources.getColor(this)
fun Int.fromResDimen(context: Context) = context.resources.getDimension(this)
fun Int.fromResDrawable(context: Context) = context.resources.getDrawable(this)
fun Int.fromResDrawableTinted(context: Context, color: Int = Color.WHITE) = context.resources.getDrawable(this).tint(color)