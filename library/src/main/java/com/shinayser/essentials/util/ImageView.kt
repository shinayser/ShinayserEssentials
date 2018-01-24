package com.shinayser.essentials.util

import android.widget.ImageView

/**
 * Created by Daniel Oliveira on 18/12/2017.
 */
infix fun ImageView.tint(color: Int) = apply { this.setColorFilter(color) }