package com.shinayser.essentials.util

import android.widget.ImageView

/**
 * Created by denox on 18/12/2017.
 */
fun ImageView.tint(color: Int): ImageView {
    this.setColorFilter(color)
    return this
}