package com.shinayser.essentials.util

import android.content.res.Resources
import android.util.TypedValue
import com.shinayser.essentials.R

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
fun Resources.Theme.getPrimaryColor(): Int {
    val typedValue = TypedValue()
    this.resolveAttribute(R.attr.colorPrimary, typedValue, true)
    return typedValue.data
}

fun Resources.Theme.getColorAccent(): Int {
    val typedValue = TypedValue()
    this.resolveAttribute(R.attr.colorAccent, typedValue, true)
    return typedValue.data
}

fun Resources.Theme.getPrimaryColorDark(): Int {
    val typedValue = TypedValue()
    this.resolveAttribute(R.attr.colorPrimaryDark, typedValue, true)
    return typedValue.data
}