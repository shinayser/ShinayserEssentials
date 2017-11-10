package com.shinayer.essentials.util

import android.graphics.drawable.Drawable
import android.support.v4.graphics.drawable.DrawableCompat

/**
 * Created by denox on 10/11/2017.
 */
fun Drawable.tint(color: Int): Drawable {
    this.mutate()
    val drawable = DrawableCompat.wrap(this)
    DrawableCompat.setTint(drawable, color)
    return drawable
}