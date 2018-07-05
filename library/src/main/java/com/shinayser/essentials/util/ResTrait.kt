package com.shinayser.essentials.util

import android.content.Context

interface ResTrait {

	fun getContext(): Context?

	fun Int.stringRes() = getContext()!!.resources.getString(this)
	fun Int.stringRes(vararg formatArgs: Any) = getContext()!!.resources.getString(this, *formatArgs)
	fun Int.stringArrayRes() = getContext()!!.resources.getStringArray(this)
	fun Int.intRes() = getContext()!!.resources.getInteger(this)
	fun Int.intArrayRes() = getContext()!!.resources.getIntArray(this)
	fun Int.booleanRes() = getContext()!!.resources.getBoolean(this)
	fun Int.colorRes() = getContext()!!.resources.getColor(this)
	fun Int.dimensionRes() = getContext()!!.resources.getDimension(this)
	fun Int.drawableRes() = getContext()!!.resources.getDrawable(this)

}