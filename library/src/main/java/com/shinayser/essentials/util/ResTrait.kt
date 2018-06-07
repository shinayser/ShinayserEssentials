package com.shinayser.essentials.util

import android.content.Context

interface ResTrait {

	fun getApplicationContext(): Context

	fun Int.stringRes() = getApplicationContext().resources.getString(this)
	fun Int.stringArrayRes() = getApplicationContext().resources.getStringArray(this)
	fun Int.intRes() = getApplicationContext().resources.getInteger(this)
	fun Int.intArrayRes() = getApplicationContext().resources.getIntArray(this)
	fun Int.booleanRes() = getApplicationContext().resources.getBoolean(this)
	fun Int.colorRes() = getApplicationContext().resources.getColor(this)
	fun Int.dimensionRes() = getApplicationContext().resources.getDimension(this)
	fun Int.drawableRes() = getApplicationContext().resources.getDrawable(this)

}