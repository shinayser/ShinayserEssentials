package com.shinayer.essentials.util

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


//Integer resources quick convertion
fun Int.fromResString(context: Context, vararg params: Any) = if (params.isEmpty()) context.getString(this) else context.getString(this, params)
fun Int.fromResInteger(context: Context) = context.resources.getInteger(this)
fun Int.fromResColor(context: Context) = context.resources.getColor(this)
fun Int.fromResDimen(context: Context) = context.resources.getDimension(this)
fun Int.fromResDrawable(context: Context) = context.resources.getDrawable(this)
fun Int.fromResDrawableTinted(context: Context, color: Int = Color.WHITE) = context.resources.getDrawable(this).tint(color)