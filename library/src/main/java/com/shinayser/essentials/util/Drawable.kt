package com.shinayser.essentials.util

import android.graphics.drawable.Drawable
import androidx.core.graphics.drawable.DrawableCompat

/**
 * Created by Daniel Oliveira on 10/11/2017.
 */
fun Drawable.tint(color: Int): Drawable {
    this.mutate()
    val drawable = DrawableCompat.wrap(this)
    DrawableCompat.setTint(drawable, color)
    return drawable
}